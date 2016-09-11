package dan.vhack;

public class TrojanData {

	private String result;
	private int amount;
	private int elo;
	private int eloch;
	private int newmoney;
	
	public TrojanData() {
		super();
	}

	public String getResult() {
		return result;
	}

	public void setResult(String result) {
		this.result = result;
	}

	public int getAmount() {
		return amount;
	}

	public void setAmount(int amount) {
		this.amount = amount;
	}

	public int getElo() {
		return elo;
	}

	public void setElo(int elo) {
		this.elo = elo;
	}

	public int getEloch() {
		return eloch;
	}

	public void setEloch(int eloch) {
		this.eloch = eloch;
	}

	public int getNewmoney() {
		return newmoney;
	}

	public void setNewmoney(int newmoney) {
		this.newmoney = newmoney;
	}

	@Override
	public String toString() {
		return "Gained: " + this.amount + " - New money: " + this.newmoney;
	}
	
}
