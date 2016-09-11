package dan.vhack;

import com.fasterxml.jackson.annotation.JsonProperty;

public class UpgradeInfoData {

	private String costs;
	private String type;
	private String money;
	private String newLevel;
	
	public UpgradeInfoData() {
		super();
	}
	public String getCosts() {
		return costs;
	}
	public void setCosts(String costs) {
		this.costs = costs;
	}
	public String getType() {
		return type;
	}
	public void setType(String type) {
		this.type = type;
	}
	public String getMoney() {
		return money;
	}
	public void setMoney(String money) {
		this.money = money;
	}
	public String getNewLevel() {
		return newLevel;
	}
	@JsonProperty("new")
	public void setNewLevel(String newLevel) {
		this.newLevel = newLevel;
	}
	@Override
	public String toString() {
		int have = Integer.valueOf(this.money).intValue();
		int costs =  Integer.valueOf(this.costs).intValue();
		int need = have - costs;
		if(need > 0) {
			return "Need " + need + "more money to upgrade "+ this.type + " to " + this.newLevel;	
		} else {
			return "Can upgrade "+ this.type + " to " + this.newLevel;
		}
		
	}
	
	//{"costs":"2998000","type":"inet","money":"21139600","new":"8"}
}
