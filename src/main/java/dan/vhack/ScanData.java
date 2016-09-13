package dan.vhack;

import java.util.Date;

import org.jongo.marshall.jackson.oid.MongoId;

public class ScanData {

	@MongoId
	private String ip;
	private String username;
	private int firewall;
	private int antivirus;
	private int scan;
	private int sdk;
	private int spam;
	private int money;
	private boolean anonymous;
	private int success;
	private boolean error;
	private Date lastScanned;
	private int score;
	
	public ScanData() {
		super();
	}

	public String getIp() {
		return ip;
	}

	public void setIp(String ip) {
		this.ip = ip;
	}

	public String getUsername() {
		return username;
	}

	public void setUsername(String username) {
		this.username = username;
	}

	public int getFirewall() {
		return firewall;
	}

	public void setFirewall(int firewall) {
		this.firewall = firewall;
	}

	public int getAntivirus() {
		return antivirus;
	}

	public void setAntivirus(int antivirus) {
		this.antivirus = antivirus;
	}

	public int getScan() {
		return scan;
	}

	public void setScan(int scan) {
		this.scan = scan;
	}

	public int getSdk() {
		return sdk;
	}

	public void setSdk(int sdk) {
		this.sdk = sdk;
	}

	public int getSpam() {
		return spam;
	}

	public void setSpam(int spam) {
		this.spam = spam;
	}

	public int getMoney() {
		return money;
	}

	public void setMoney(int money) {
		this.money = money;
	}

	public boolean isAnonymous() {
		return anonymous;
	}

	public void setAnonymous(boolean anonymous) {
		this.anonymous = anonymous;
	}

	public int getSuccess() {
		return success;
	}

	public void setSuccess(int success) {
		this.success = success;
	}

	public boolean isError() {
		return error;
	}

	public void setError(boolean error) {
		this.error = error;
	}
	
	public Date getLastScanned() {
		return lastScanned;
	}

	public void setLastScanned(Date lastScanned) {
		this.lastScanned = lastScanned;
	}

	public int getScore() {
		return score;
	}

	public void setScore(int score) {
		this.score = score;
	}

	@Override
	public String toString() {
		return "Score: " + this.score + " - AV: " + this.antivirus + " - Money: " + this.money + " - Success: " + this.success;
	}

}
