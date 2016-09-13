package dan.vhack;

public class UpgradeCalc {

	private String type;
	private String messageValue;
	private int weight;
	private int existingLevel;
	private double score;

	public UpgradeCalc(String type, int weight, String messageValue, int existingLevel) {
		super();
		this.type = type;
		this.weight = weight;
		this.messageValue = messageValue;
		this.existingLevel = existingLevel;
	}

	public String getType() {
		return type;
	}

	public void setType(String type) {
		this.type = type;
	}

	public String getMessageValue() {
		return messageValue;
	}

	public int getWeight() {
		return weight;
	}

	public void setWeight(int weight) {
		this.weight = weight;
	}

	public void setMessageValue(String messageValue) {
		this.messageValue = messageValue;
	}

	public int getExistingLevel() {
		return existingLevel;
	}

	public void setExistingLevel(int existingLevel) {
		this.existingLevel = existingLevel;
	}

	public double getScore() {
		return score;
	}

	public void setScore(double score) {
		this.score = score;
	}

	@Override
	public String toString() {
		return type + " - " + existingLevel + " - " + weight + " = " + score;
	}
}
