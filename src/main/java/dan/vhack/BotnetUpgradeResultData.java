package dan.vhack;

import com.fasterxml.jackson.annotation.JsonProperty;

public class BotnetUpgradeResultData {

	private int costs;
	private int lvl;
	private int mm;
	private int money;
	private int newLevel;
	private int old;
	private int strength;
	private boolean error;

	public BotnetUpgradeResultData() {
		super();
	}

	public int getCosts() {
		return costs;
	}

	public void setCosts(int costs) {
		this.costs = costs;
	}

	public int getLvl() {
		return lvl;
	}

	public void setLvl(int lvl) {
		this.lvl = lvl;
	}

	public int getMm() {
		return mm;
	}

	public void setMm(int mm) {
		this.mm = mm;
	}

	public int getMoney() {
		return money;
	}

	public void setMoney(int money) {
		this.money = money;
	}

	public int getNewLevel() {
		return newLevel;
	}

	@JsonProperty("new")
	public void setNewLevel(int newLevel) {
		this.newLevel = newLevel;
	}

	public int getOld() {
		return old;
	}

	public void setOld(int old) {
		this.old = old;
	}

	public int getStrength() {
		return strength;
	}

	public void setStrength(int strength) {
		this.strength = strength;
	}

	public boolean isError() {
		return error;
	}

	public void setError(boolean error) {
		this.error = error;
	}

}
