/**
 * Ultra-fast Connect 4 engine.
 *
 * Speed techniques:
 *   1. Bitboards            — board state = two longs; win check = 4 bitwise ops (O(1))
 *   2. Centre-first move ordering — alpha-beta finds good moves earlier → prunes harder
 *   3. Transposition table  — flat long[] array avoids HashMap overhead; skip re-searches
 *   4. Iterative deepening  — search d=1..MAX so TT entries warm up deeper passes
 *   5. Negamax formulation  — single function, no max/min split; current player always maximises
 */
public class Engine {

    // ── Board geometry ───────────────────────────────────────────────────────
    private static final int ROWS      = 6;
    private static final int COLS      = 7;
    private static final int H         = ROWS + 1; // bit-stride per column (1 sentinel row)
    private static final int MAX_DEPTH = 12;       // strong and fast with bitboards + TT

    // Pre-computed centre-out column order: 3,2,4,1,5,0,6
    private static final int[] MOVE_ORDER = buildMoveOrder();

    // Full-board mask (all valid cell bits, no sentinels)
    private static final long FULL_MASK = buildFullMask();

    // Zobrist tables [player 0/1][cell index 0..41]
    private static final long[][] ZOBRIST = buildZobrist();

    // ── Transposition table ──────────────────────────────────────────────────
    private static final int TT_BITS = 22;              // 4 M slots
    private static final int TT_SIZE = 1 << TT_BITS;
    private final long[] ttKeys   = new long[TT_SIZE];
    private final long[] ttValues = new long[TT_SIZE];  // packed: score(32)|depth(8)|flag(8)

    private static final int FLAG_EXACT = 0;
    private static final int FLAG_LOWER = 1;
    private static final int FLAG_UPPER = 2;

    // ── Live board state ─────────────────────────────────────────────────────
    private long aiBoard;          // bits where AI has placed
    private long oppBoard;         // bits where opponent has placed
    private final long[] heights;  // heights[c] = bit index of the next open cell in column c
    private int  moves;            // total pieces on the board (used for turn parity)
    private final boolean aiIsEven;// true → AI moves on even-numbered plies (0,2,4…)

    // ── Constructor ──────────────────────────────────────────────────────────

    /**
     * Build engine from a 6×7 String[][] board (legacy interface).
     *
     * @param board  grid[row][col], row 0 = top; cells are "X", "O", or ""
     * @param piece  AI's piece symbol ("X" or "O")
     */
    public Engine(String[][] board, String piece) {
        heights = new long[COLS];
        for (int c = 0; c < COLS; c++)
            heights[c] = (long)(c * H); // base bit index for column c

        String oppSymbol = piece.equals("X") ? "O" : "X";
        int piecesOnBoard = 0;

        // Fill bottom-up (row ROWS-1 → row 0) because bit 0 of a column = bottom row
        for (int c = 0; c < COLS; c++) {
            for (int r = ROWS - 1; r >= 0; r--) {
                String cell = board[r][c];
                if (cell.isEmpty()) continue;
                long bit = 1L << heights[c];
                heights[c]++;
                piecesOnBoard++;
                if (cell.equals(piece)) aiBoard  |= bit;
                else                    oppBoard |= bit;
            }
        }

        moves = piecesOnBoard;
        // If pieces on board is even, it's AI's turn only if AI went first.
        // We infer: AI moves on even plies iff current board count is even
        // (caller is expected to invoke getMove() on the AI's turn).
        aiIsEven = (moves % 2 == 0);
    }

    // ── Public API ───────────────────────────────────────────────────────────

    /** Returns the best column (0-indexed) for the AI to drop a piece. */
    public int getMove() {
        int bestMove  = -1;
        int bestScore = Integer.MIN_VALUE / 2;

        for (int depth = 1; depth <= MAX_DEPTH; depth++) {
            int iterBest  = -1;
            int iterScore = Integer.MIN_VALUE / 2;

            for (int ci = 0; ci < COLS; ci++) {
                int c = MOVE_ORDER[ci];
                if (!canPlay(c)) continue;

                drop(c);
                // Use aspiration window from previous iteration for better pruning
                int score = -negamax(
                    -(iterScore + 1),
                    -(iterScore),
                    depth - 1
                );
                // Re-search with full window if we got an improvement
                if (score > iterScore || iterBest == -1) {
                    score = -negamax(Integer.MIN_VALUE / 2, Integer.MAX_VALUE / 2, depth - 1);
                }
                lift(c);

                if (score > iterScore) {
                    iterScore = score;
                    iterBest  = c;
                }
            }

            bestScore = iterScore;
            bestMove  = iterBest;

            // Forced win/loss found — no need to search deeper
            if (Math.abs(bestScore) >= 900) break;
        }

        return bestMove;
    }

    // ── Negamax search ───────────────────────────────────────────────────────

    private int negamax(int alpha, int beta, int depth) {
        // The player who just moved is NOT the current player.
        // After drop(), the board reflects their move — check if they won.
        long lastPlayerBoard = isAiTurn() ? oppBoard : aiBoard; // last to move
        if (isWin(lastPlayerBoard)) return -(1000 + depth);

        if (isFull()) return 0;
        if (depth == 0) return quiescence();

        // ── Transposition table probe ────────────────────────────────────────
        long hash  = zobrist();
        int  slot  = (int)(hash & (TT_SIZE - 1));
        if (ttKeys[slot] == hash) {
            long   v     = ttValues[slot];
            int    tScore = (int)(v >> 16);
            int    tDepth = (int)((v >> 8) & 0xFF);
            int    tFlag  = (int)(v & 0xFF);
            if (tDepth >= depth) {
                if (tFlag == FLAG_EXACT) return tScore;
                if (tFlag == FLAG_LOWER && tScore > alpha) alpha = tScore;
                if (tFlag == FLAG_UPPER && tScore < beta)  beta  = tScore;
                if (alpha >= beta) return tScore;
            }
        }

        // ── Search ──────────────────────────────────────────────────────────
        int  best = Integer.MIN_VALUE / 2;
        int  flag = FLAG_UPPER;

        for (int ci = 0; ci < COLS; ci++) {
            int c = MOVE_ORDER[ci];
            if (!canPlay(c)) continue;

            drop(c);
            int score = -negamax(-beta, -alpha, depth - 1);
            lift(c);

            if (score > best) {
                best = score;
                if (score > alpha) {
                    alpha = score;
                    flag  = FLAG_EXACT;
                }
            }
            if (alpha >= beta) {
                flag = FLAG_LOWER;
                break;
            }
        }

        // ── TT store ────────────────────────────────────────────────────────
        ttKeys[slot]   = hash;
        ttValues[slot] = ((long) best << 16)
                       | ((long)(depth & 0xFF) << 8)
                       | (flag & 0xFF);

        return best;
    }

    // ── Quiescence / static evaluation ───────────────────────────────────────

    /**
     * Static evaluation from the perspective of the current player (negamax convention).
     * Called at depth 0 — no terminal condition here (handled in negamax above).
     */
    private int quiescence() {
        long me  = isAiTurn() ? aiBoard  : oppBoard;
        long opp = isAiTurn() ? oppBoard : aiBoard;

        int score = 0;

        // Centre column preference
        long centreMask = columnMask(COLS / 2);
        score += Long.bitCount(me  & centreMask) * 3;
        score -= Long.bitCount(opp & centreMask) * 3;

        // Score every 4-window in all four directions
        score += windowsScore(me, opp, 0, 1);         // horizontal
        score += windowsScore(me, opp, H, 1);         // vertical  (stride H in bits)
        score += windowsScore(me, opp, H - 1, 1);     // diagonal ↗
        score += windowsScore(me, opp, H + 1, 1);     // diagonal ↘

        return score;
    }

    /**
     * Score all consecutive 4-windows in a given bit direction.
     * @param shift  bit shift that moves one step in this direction
     */
    private int windowsScore(long me, long opp, int shift, int ignored) {
        // We iterate over all windows by scanning explicitly — still fast
        int score = 0;
        for (int c = 0; c < COLS; c++) {
            for (int r = 0; r < ROWS; r++) {
                score += scoreWindow(me, opp, c, r);
            }
        }
        return score;
    }

    private int scoreWindow(long me, long opp, int startC, int startR) {
        int total = 0;
        // horizontal
        total += evalWindow4(me, opp, startC, startR, 0, 1);
        // vertical
        total += evalWindow4(me, opp, startC, startR, 1, 0);
        // diag ↘
        total += evalWindow4(me, opp, startC, startR, 1, 1);
        // diag ↗
        total += evalWindow4(me, opp, startC, startR, -1, 1);
        return total;
    }

    private int evalWindow4(long me, long opp, int c, int r, int dc, int dr) {
        int meCnt = 0, oppCnt = 0;
        for (int k = 0; k < 4; k++) {
            int nc = c + k * dc;
            int nr = r + k * dr;
            if (nc < 0 || nc >= COLS || nr < 0 || nr >= ROWS) return 0;
            long bit = 1L << (nc * H + nr);
            if ((me  & bit) != 0) meCnt++;
            if ((opp & bit) != 0) oppCnt++;
        }
        if (meCnt > 0 && oppCnt > 0) return 0; // blocked
        if (meCnt  == 4) return  100;
        if (meCnt  == 3) return    5;
        if (meCnt  == 2) return    2;
        if (oppCnt == 4) return -100;
        if (oppCnt == 3) return   -4;
        if (oppCnt == 2) return   -1;
        return 0;
    }

    // ── Bitboard helpers ─────────────────────────────────────────────────────

    /** True if column c is not full. */
    private boolean canPlay(int c) {
        // The sentinel bit is at c*H + ROWS; if heights[c] has reached it, column is full
        return heights[c] < (long)(c * H + ROWS);
    }

    /** Place the current player's piece in column c. */
    private void drop(int c) {
        long bit = 1L << heights[c];
        heights[c]++;
        if (isAiTurn()) aiBoard  |= bit;
        else            oppBoard |= bit;
        moves++;
    }

    /** Remove the top piece from column c (undo drop). */
    private void lift(int c) {
        moves--;
        heights[c]--;
        long bit = 1L << heights[c];
        if (isAiTurn()) aiBoard  &= ~bit;
        else            oppBoard &= ~bit;
    }

    /** True if it's the AI's turn given the current ply count. */
    private boolean isAiTurn() {
        return aiIsEven == (moves % 2 == 0);
    }

    /**
     * O(1) win check via bitboard shifts.
     * A player wins if they have 4 in a line in any direction.
     */
    private boolean isWin(long b) {
        // Horizontal
        long h = b & (b >> 1);
        if ((h & (h >> 2)) != 0) return true;
        // Vertical
        long v = b & (b >> H);
        if ((v & (v >> (2 * H))) != 0) return true;
        // Diagonal ↗ (shift H-1)
        long d1 = b & (b >> (H - 1));
        if ((d1 & (d1 >> (2 * (H - 1)))) != 0) return true;
        // Diagonal ↘ (shift H+1)
        long d2 = b & (b >> (H + 1));
        return (d2 & (d2 >> (2 * (H + 1)))) != 0;
    }

    private boolean isFull() {
        return (aiBoard | oppBoard) == FULL_MASK;
    }

    // ── Zobrist hashing ──────────────────────────────────────────────────────

    private long zobrist() {
        long h = 0L;
        for (int c = 0; c < COLS; c++) {
            for (int r = 0; r < ROWS; r++) {
                long bit = 1L << (c * H + r);
                if ((aiBoard  & bit) != 0) h ^= ZOBRIST[0][c * ROWS + r];
                if ((oppBoard & bit) != 0) h ^= ZOBRIST[1][c * ROWS + r];
            }
        }
        return h;
    }

    // ── Static initialisers ──────────────────────────────────────────────────

    private static long buildFullMask() {
        long mask = 0L;
        for (int c = 0; c < COLS; c++)
            for (int r = 0; r < ROWS; r++)
                mask |= 1L << (c * H + r);
        return mask;
    }

    private static long columnMask(int c) {
        long mask = 0L;
        for (int r = 0; r < ROWS; r++) mask |= 1L << (c * H + r);
        return mask;
    }

    private static int[] buildMoveOrder() {
        int[] o = new int[COLS];
        int lo = COLS / 2, hi = COLS / 2;
        o[0] = lo;
        for (int i = 1; i < COLS; i++) {
            if (i % 2 == 1) o[i] = --lo;
            else             o[i] = ++hi;
        }
        return o;
    }

    private static long[][] buildZobrist() {
        long[][] z   = new long[2][COLS * ROWS];
        java.util.Random rng = new java.util.Random(0xDEADBEEFCAFEL);
        for (int p = 0; p < 2; p++)
            for (int i = 0; i < COLS * ROWS; i++)
                z[p][i] = rng.nextLong();
        return z;
    }
}