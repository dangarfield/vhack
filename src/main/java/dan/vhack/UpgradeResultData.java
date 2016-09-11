package dan.vhack;

import com.fasterxml.jackson.annotation.JsonProperty;

public class UpgradeResultData {

	private int costs;
	private String type;
	private String av;
	private String fw;
	private String sdk;
	private String ipsp;
	private String spam;
	private String scan;
	private String adw;
	private String cpu;
	private String ram;
	private String hdd;
	private String inet;
	private String money;
	private String newLevel;
	private String result;
	
	public UpgradeResultData() {
		super();
	}

	public int getCosts() {
		return costs;
	}

	public void setCosts(int costs) {
		this.costs = costs;
	}

	public String getType() {
		return type;
	}

	public void setType(String type) {
		this.type = type;
	}

	public String getAv() {
		return av;
	}

	public void setAv(String av) {
		this.av = av;
	}

	public String getFw() {
		return fw;
	}

	public void setFw(String fw) {
		this.fw = fw;
	}

	public String getSdk() {
		return sdk;
	}

	public void setSdk(String sdk) {
		this.sdk = sdk;
	}

	public String getIpsp() {
		return ipsp;
	}

	public void setIpsp(String ipsp) {
		this.ipsp = ipsp;
	}

	public String getSpam() {
		return spam;
	}

	public void setSpam(String spam) {
		this.spam = spam;
	}

	public String getScan() {
		return scan;
	}

	public void setScan(String scan) {
		this.scan = scan;
	}

	public String getAdw() {
		return adw;
	}

	public void setAdw(String adw) {
		this.adw = adw;
	}

	public String getCpu() {
		return cpu;
	}

	public void setCpu(String cpu) {
		this.cpu = cpu;
	}

	public String getRam() {
		return ram;
	}

	public void setRam(String ram) {
		this.ram = ram;
	}

	public String getHdd() {
		return hdd;
	}

	public void setHdd(String hdd) {
		this.hdd = hdd;
	}

	public String getInet() {
		return inet;
	}

	public void setInet(String inet) {
		this.inet = inet;
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

	public String getResult() {
		return result;
	}

	public void setResult(String result) {
		this.result = result;
	}
}
