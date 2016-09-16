package dan.vhack;

public class BotnetInfoDataItem {

	private int bID;
	private int bLVL;
	private int bPRICE;
	private int bSTR;

	public BotnetInfoDataItem() {
		super();
	}

	public int getbID() {
		return bID;
	}

	public void setbID(int bID) {
		this.bID = bID;
	}

	public int getbLVL() {
		return bLVL;
	}

	public void setbLVL(int bLVL) {
		this.bLVL = bLVL;
	}

	public int getbPRICE() {
		return bPRICE;
	}

	public void setbPRICE(int bPRICE) {
		this.bPRICE = bPRICE;
	}

	public int getbSTR() {
		return bSTR;
	}

	public void setbSTR(int bSTR) {
		this.bSTR = bSTR;
	}

	@Override
	public String toString() {
		return this.bID + " - Level: " + bLVL;
	}
}
