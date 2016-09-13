package dan.vhack;

public class BonusData {

	private String type;
	private int win;
	private int bleft;
	private int lvl;
	private boolean error;

	public BonusData() {
		super();
	}

	public String getType() {
		return type;
	}

	public void setType(String type) {
		this.type = type;
	}

	public int getWin() {
		return win;
	}

	public void setWin(int win) {
		this.win = win;
	}

	public int getBleft() {
		return bleft;
	}

	public void setBleft(int bleft) {
		this.bleft = bleft;
	}

	public int getLvl() {
		return lvl;
	}

	public void setLvl(int lvl) {
		this.lvl = lvl;
	}

	public boolean isError() {
		return error;
	}

	public void setError(boolean error) {
		this.error = error;
	}

}
