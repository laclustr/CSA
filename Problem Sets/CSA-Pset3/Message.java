public class Message {
	private int messageNum;
	private int lineNum;
	private String text;

	public Message(int messageNum, int lineNum, String text) {
		this.messageNum = messageNum;
		this.lineNum = lineNum;
		this.text = text;
	}

	public int compare(Message other) {
		if (this.messageNum != other.messageNum) {
			return this.messageNum - other.messageNum;
		}
		return this.lineNum - other.lineNum;
	}

	public int getLineNum() {
		return lineNum;
	}

	public int getMessageNum() {
		return messageNum;
	}

	public String getText() {
		return text;
	}
}