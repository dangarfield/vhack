package dan.vhack;

public class NetworkDataItem {

	private String ip;
	private int fw;
	private String attacked;

	public NetworkDataItem() {
		super();
	}

	public String getIp() {
		return ip;
	}

	public void setIp(String ip) {
		this.ip = ip;
	}

	public int getFw() {
		return fw;
	}

	public void setFw(int fw) {
		this.fw = fw;
	}

	public String getAttacked() {
		return attacked;
	}

	public void setAttacked(String attacked) {
		this.attacked = attacked;
	}

	@Override
	public String toString() {
		return this.ip + " - FW: " + this.fw + " (attacked: " + this.attacked + ")"; 
	}
}
