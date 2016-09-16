package dan.vhack;

public class UserData {

	private int bonus;
	private int use;
	private int scan;
	private String syslog;
	private String actadw;
	private int fw;
	private int score;
	private int rank;
	private int id;
	private int event;
	private String lastcmsg;
	private int ram;
	private int energy;
	private String uhash;
	private int inet;
	private String ip;
	private int hdd;
	private int cpu;
	private int active;
	private int elo;
	private int netcoins;
	private int clusterID;
	private int mystery;
	private int money;
	private String urmail;
	private int av;
	private int ipsp;
	private int adw;
	private int sdk;
	private String position;
	private int spam;
	private String hash;
	private Auth auth;

	public UserData() {
		super();
	}

	public int getBonus() {
		return bonus;
	}

	public void setBonus(int bonus) {
		this.bonus = bonus;
	}

	public int getUse() {
		return use;
	}

	public void setUse(int use) {
		this.use = use;
	}

	public int getScan() {
		return scan;
	}

	public void setScan(int scan) {
		this.scan = scan;
	}

	public String getSyslog() {
		return syslog;
	}

	public void setSyslog(String syslog) {
		this.syslog = syslog;
	}

	public String getActadw() {
		return actadw;
	}

	public void setActadw(String actadw) {
		this.actadw = actadw;
	}

	public int getFw() {
		return fw;
	}

	public void setFw(int fw) {
		this.fw = fw;
	}

	public int getScore() {
		return score;
	}

	public void setScore(int score) {
		this.score = score;
	}

	public int getRank() {
		return rank;
	}

	public void setRank(int rank) {
		this.rank = rank;
	}

	public int getId() {
		return id;
	}

	public void setId(int id) {
		this.id = id;
	}

	public int getEvent() {
		return event;
	}

	public void setEvent(int event) {
		this.event = event;
	}

	public String getLastcmsg() {
		return lastcmsg;
	}

	public void setLastcmsg(String lastcmsg) {
		this.lastcmsg = lastcmsg;
	}

	public int getRam() {
		return ram;
	}

	public void setRam(int ram) {
		this.ram = ram;
	}

	public int getEnergy() {
		return energy;
	}

	public void setEnergy(int energy) {
		this.energy = energy;
	}

	public String getUhash() {
		return uhash;
	}

	public void setUhash(String uhash) {
		this.uhash = uhash;
	}

	public int getInet() {
		return inet;
	}

	public void setInet(int inet) {
		this.inet = inet;
	}

	public String getIp() {
		return ip;
	}

	public void setIp(String ip) {
		this.ip = ip;
	}

	public int getHdd() {
		return hdd;
	}

	public void setHdd(int hdd) {
		this.hdd = hdd;
	}

	public int getCpu() {
		return cpu;
	}

	public void setCpu(int cpu) {
		this.cpu = cpu;
	}

	public int getActive() {
		return active;
	}

	public void setActive(int active) {
		this.active = active;
	}

	public int getElo() {
		return elo;
	}

	public void setElo(int elo) {
		this.elo = elo;
	}

	public int getNetcoins() {
		return netcoins;
	}

	public void setNetcoins(int netcoins) {
		this.netcoins = netcoins;
	}

	public int getClusterID() {
		return clusterID;
	}

	public void setClusterID(int clusterID) {
		this.clusterID = clusterID;
	}

	public int getMystery() {
		return mystery;
	}

	public void setMystery(int mystery) {
		this.mystery = mystery;
	}

	public int getMoney() {
		return money;
	}

	public void setMoney(int money) {
		this.money = money;
	}

	public String getUrmail() {
		return urmail;
	}

	public void setUrmail(String urmail) {
		this.urmail = urmail;
	}

	public int getAv() {
		return av;
	}

	public void setAv(int av) {
		this.av = av;
	}

	public int getIpsp() {
		return ipsp;
	}

	public void setIpsp(int ipsp) {
		this.ipsp = ipsp;
	}

	public int getAdw() {
		return adw;
	}

	public void setAdw(int adw) {
		this.adw = adw;
	}

	public int getSdk() {
		return sdk;
	}

	public void setSdk(int sdk) {
		this.sdk = sdk;
	}

	public String getPosition() {
		return position;
	}

	public void setPosition(String position) {
		this.position = position;
	}

	public int getSpam() {
		return spam;
	}

	public void setSpam(int spam) {
		this.spam = spam;
	}

	public String getHash() {
		return hash;
	}

	public void setHash(String hash) {
		this.hash = hash;
	}

	public Auth getAuth() {
		return auth;
	}

	public void setAuth(Auth auth) {
		this.auth = auth;
	}

	@Override
	public String toString() {
		StringBuilder sb = new StringBuilder();
		sb.append(this.ip);
		sb.append(" - Money: " + this.money);
		sb.append(" - Scan: " + this.scan);
		sb.append(" - SDK: " + this.sdk);
		sb.append(" - FW: " + this.fw);
		sb.append(" - AV: " + this.av);
		return sb.toString();
	}
}
