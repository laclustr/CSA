import java.awt.image.BufferedImage;
import java.awt.image.WritableRaster;
import java.io.File;
import java.io.IOException;
import javax.imageio.ImageIO;

public class ImageJava {

    private static final String[] VALID_IMG_EXTENSIONS = {
        "bmp", "jpg", "jpeg", "gif", "png", "jfif", "tif"
    };

    public static boolean isImage(String path) {
        String lower = path.toLowerCase();
        for (String ext : VALID_IMG_EXTENSIONS) {
            if (lower.endsWith("." + ext)) {
                return true;
            }
        }
        return false;
    }

    public static int[][] loadGrayscale(String path) throws IOException {
        if (!isImage(path)) {
            throw new IllegalArgumentException(path + " is not a valid image type.");
        }
        BufferedImage img = ImageIO.read(new File(path));
        if (img == null) throw new IOException("Could not read image: " + path);

        int width = img.getWidth();
        int height = img.getHeight();
        int[][] gray = new int[height][width];

        for (int y = 0; y < height; y++) {
            for (int x = 0; x < width; x++) {
                int rgb = img.getRGB(x, y);
                int r = (rgb >> 16) & 0xff;
                int g = (rgb >> 8) & 0xff;
                int b = rgb & 0xff;
                int luminance = (r + g + b) / 3;
                gray[y][x] = luminance;
            }
        }
        return gray;
    }

    public static int[][][] loadRGB(String path) throws IOException {
        if (!isImage(path)) {
            throw new IllegalArgumentException(path + " is not a valid image type.");
        }
        BufferedImage img = ImageIO.read(new File(path));
        if (img == null) throw new IOException("Could not read image: " + path);

        int width = img.getWidth();
        int height = img.getHeight();
        int[][][] rgbArray = new int[height][width][3];

        for (int y = 0; y < height; y++) {
            for (int x = 0; x < width; x++) {
                int rgb = img.getRGB(x, y);
                rgbArray[y][x][0] = (rgb >> 16) & 0xff; // R
                rgbArray[y][x][1] = (rgb >> 8) & 0xff;  // G
                rgbArray[y][x][2] = rgb & 0xff;         // B
            }
        }
        return rgbArray;
    }

    public static void showImage(int[][] gray) {
        int height = gray.length;
        int width = gray[0].length;
        BufferedImage img = new BufferedImage(width, height, BufferedImage.TYPE_BYTE_GRAY);
        WritableRaster raster = img.getRaster();

        for (int y = 0; y < height; y++) {
            for (int x = 0; x < width; x++) {
                raster.setSample(x, y, 0, gray[y][x]);
            }
        }
        javax.swing.JFrame frame = new javax.swing.JFrame("Image Viewer");
        frame.getContentPane().add(new javax.swing.JLabel(new javax.swing.ImageIcon(img)));
        frame.pack();
        frame.setVisible(true);
    }

    public static void showImage(int[][][] rgb) {
        int height = rgb.length;
        int width = rgb[0].length;
        BufferedImage img = new BufferedImage(width, height, BufferedImage.TYPE_INT_RGB);

        for (int y = 0; y < height; y++) {
            for (int x = 0; x < width; x++) {
                int r = rgb[y][x][0];
                int g = rgb[y][x][1];
                int b = rgb[y][x][2];
                int rgbVal = (r << 16) | (g << 8) | b;
                img.setRGB(x, y, rgbVal);
            }
        }
        javax.swing.JFrame frame = new javax.swing.JFrame("Image Viewer");
        frame.getContentPane().add(new javax.swing.JLabel(new javax.swing.ImageIcon(img)));
        frame.pack();
        frame.setDefaultCloseOperation(javax.swing.JFrame.EXIT_ON_CLOSE);
        frame.setVisible(true);
    }

    public static void saveImage(int[][] gray, String path) throws IOException {
        int height = gray.length;
        int width = gray[0].length;
        BufferedImage img = new BufferedImage(width, height, BufferedImage.TYPE_BYTE_GRAY);
        WritableRaster raster = img.getRaster();

        for (int y = 0; y < height; y++) {
            for (int x = 0; x < width; x++) {
                raster.setSample(x, y, 0, gray[y][x]);
            }
        }
        ImageIO.write(img, "png", new File(path));
    }

    public static void saveImage(int[][][] rgb, String path) throws IOException {
        int height = rgb.length;
        int width = rgb[0].length;
        BufferedImage img = new BufferedImage(width, height, BufferedImage.TYPE_INT_RGB);

        for (int y = 0; y < height; y++) {
            for (int x = 0; x < width; x++) {
                int r = rgb[y][x][0];
                int g = rgb[y][x][1];
                int b = rgb[y][x][2];
                int rgbVal = (r << 16) | (g << 8) | b;
                img.setRGB(x, y, rgbVal);
            }
        }
        ImageIO.write(img, "png", new File(path));
    }
}
