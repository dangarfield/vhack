package dan.vhack;

import java.util.List;

public class TaskData {

	private String adw;
	private String av;
	private String cpu;
	private String energy;
	private String fw;
	private String hdd;
	private String inet;
	private String ipsp;
	private String money;
	private String netcoins;
	private String ram;
	private String scan;
	private String sdk;
	private String spam;
	private String urmail;
	private String score;
	private List<TaskDataItem> data;

	public TaskData() {
		super();
	}

	public String getAdw() {
		return adw;
	}

	public void setAdw(String adw) {
		this.adw = adw;
	}

	public String getAv() {
		return av;
	}

	public void setAv(String av) {
		this.av = av;
	}

	public String getCpu() {
		return cpu;
	}

	public void setCpu(String cpu) {
		this.cpu = cpu;
	}

	public String getEnergy() {
		return energy;
	}

	public void setEnergy(String energy) {
		this.energy = energy;
	}

	public String getFw() {
		return fw;
	}

	public void setFw(String fw) {
		this.fw = fw;
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

	public String getIpsp() {
		return ipsp;
	}

	public void setIpsp(String ipsp) {
		this.ipsp = ipsp;
	}

	public String getMoney() {
		return money;
	}

	public void setMoney(String money) {
		this.money = money;
	}

	public String getNetcoins() {
		return netcoins;
	}

	public void setNetcoins(String netcoins) {
		this.netcoins = netcoins;
	}

	public String getRam() {
		return ram;
	}

	public void setRam(String ram) {
		this.ram = ram;
	}

	public String getScan() {
		return scan;
	}

	public void setScan(String scan) {
		this.scan = scan;
	}

	public String getSdk() {
		return sdk;
	}

	public void setSdk(String sdk) {
		this.sdk = sdk;
	}

	public String getSpam() {
		return spam;
	}

	public void setSpam(String spam) {
		this.spam = spam;
	}

	public String getUrmail() {
		return urmail;
	}

	public void setUrmail(String urmail) {
		this.urmail = urmail;
	}

	public List<TaskDataItem> getData() {
		return data;
	}

	public void setData(List<TaskDataItem> data) {
		this.data = data;
	}

	public String getScore() {
		return score;
	}

	public void setScore(String score) {
		this.score = score;
	}

	public int freeSlots() {
		if(this.data == null) {
			return 0;
		} else {
			return this.data.size();
		}
	}
	@Override
	public String toString() {
		int max = Integer.valueOf(this.ram).intValue();
		int free = max - freeSlots();
		return free + " free slots out of " + max;
	}
	// {"data":[{"type":"av","start":"1473536432","end":"1473538486","wto":"107","taskid":"8482323"},{"type":"av","start":"1473536434","end":"1473538508","wto":"108","taskid":"8482340"}],"money":"57042300","inet":"7","hdd":"9","cpu":"8","ram":"12","fw":"52","av":"106","sdk":"36","ipsp":"1","spam":"1","scan":"53","adw":"8","netcoins":"2300","urmail":"0","score":"3243","energy":"4"}
}
