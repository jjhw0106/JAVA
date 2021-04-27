package atm;

class Account {
	private int money;
	private int accNum[];

	public int getMoney() {
		return money;
	}

	public void setMoney(int money) {
		this.money = money;
	}

	public int[] getAccNum() {
		return accNum;
	}

	public String showAccNum() {
		String accNum = "";
		for (int i = 0; i < getAccNum().length; i++) {
			accNum += String.valueOf(getAccNum()[i]);
		}
		return accNum;
	}

	public void setAccNum(int[] accNum) {
		this.accNum = accNum;
	}

	public void setAccNum(String accNum) {
		int size = accNum.length();
		this.accNum = new int[size];
		String temp[] = new String[size];
		for (int i = 0; i < size; i++) {
			temp[i] = accNum.substring(i, i + 1);
			this.accNum[i] = Integer.parseInt(temp[i]);
		}
	}
}
