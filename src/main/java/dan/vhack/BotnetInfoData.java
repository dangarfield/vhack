package dan.vhack;

import java.util.List;

public class BotnetInfoData {

	private int canAtt1;
	private int canAtt2;
	private int canAtt3;
	private int count;
	private int resethours1;
	private int resethours2;
	private int resethours3;
	private int resetminutes1;
	private int resetminutes2;
	private int resetminutes3;
	private int strength;
	private List<BotnetInfoDataItem> data;

	public BotnetInfoData() {
		super();
	}

	public int getCanAtt1() {
		return canAtt1;
	}

	public void setCanAtt1(int canAtt1) {
		this.canAtt1 = canAtt1;
	}

	public int getCanAtt2() {
		return canAtt2;
	}

	public void setCanAtt2(int canAtt2) {
		this.canAtt2 = canAtt2;
	}

	public int getCanAtt3() {
		return canAtt3;
	}

	public void setCanAtt3(int canAtt3) {
		this.canAtt3 = canAtt3;
	}

	public int getCount() {
		return count;
	}

	public void setCount(int count) {
		this.count = count;
	}

	public int getResethours1() {
		return resethours1;
	}

	public void setResethours1(int resethours1) {
		this.resethours1 = resethours1;
	}

	public int getResethours2() {
		return resethours2;
	}

	public void setResethours2(int resethours2) {
		this.resethours2 = resethours2;
	}

	public int getResethours3() {
		return resethours3;
	}

	public void setResethours3(int resethours3) {
		this.resethours3 = resethours3;
	}

	public int getResetminutes1() {
		return resetminutes1;
	}

	public void setResetminutes1(int resetminutes1) {
		this.resetminutes1 = resetminutes1;
	}

	public int getResetminutes2() {
		return resetminutes2;
	}

	public void setResetminutes2(int resetminutes2) {
		this.resetminutes2 = resetminutes2;
	}

	public int getResetminutes3() {
		return resetminutes3;
	}

	public void setResetminutes3(int resetminutes3) {
		this.resetminutes3 = resetminutes3;
	}

	public int getStrength() {
		return strength;
	}

	public void setStrength(int strength) {
		this.strength = strength;
	}

	public List<BotnetInfoDataItem> getData() {
		return data;
	}

	public void setData(List<BotnetInfoDataItem> data) {
		this.data = data;
	}

	@Override
	public String toString() {
		int botnetCount = 0;
		if (this.data != null) {
			botnetCount = this.data.size();
		}
		return botnetCount + " botnets. Total strength: " + this.strength;
	}
}
