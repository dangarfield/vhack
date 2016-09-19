package dan.vhack;

import java.util.Date;

public class MoneyQueryResult {

	private Date _id;
	private int count;
	private int money;

	public MoneyQueryResult() {
		super();
	}

	public Date get_id() {
		return _id;
	}

	public void set_id(Date _id) {
		this._id = _id;
	}

	public int getCount() {
		return count;
	}

	public void setCount(int count) {
		this.count = count;
	}

	public int getMoney() {
		return money;
	}

	public void setMoney(int money) {
		this.money = money;
	}

}
