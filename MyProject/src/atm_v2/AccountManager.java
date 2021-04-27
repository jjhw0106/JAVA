package atm_v2;

import java.util.Random;
import java.util.Scanner;
import java.util.ArrayList;

class AccountManager {
	Random ran = new Random();
	Scanner sc = new Scanner(System.in);

	private AccountManager() {
	}

	public static AccountManager accInstance = new AccountManager();

	public static AccountManager getInstance() {
		return accInstance;
	}

	static ArrayList<Account> accList = new ArrayList<Account>();

	static int accCnt = 0;

	int[] getAccNum() {
		int[] accNum = new int[9];
		accNum[0] = 1;
		accNum[1] = 1;
		accNum[2] = 0;
		for (int i = 0; i < 6; i++) {
			accNum[i + 3] = ran.nextInt(10);
		}

		return accNum;
	}

	// 배열로 이루어진 계좌를 int형으로 변환 (입금 시 계좌번호 입력 받기위해)
	static int arrToInt(int accNum[]) {
		String temp = "";
		int tempAcc = 0;
		for (int i = 0; i < 9; i++) {
			temp += String.valueOf(accNum[i]);
			tempAcc = Integer.parseInt(temp);
		}
		return tempAcc;
	}

	int getMoney() {
		System.out.print("입금액: ");
		int money = sc.nextInt();
		return money;
	}

//	int getAccIdx(int log, int accNum) {
//		
//		int idx = 0;
//		int accountNum=UserManager.uList.g
//		for(int i=0;i<AccountManager.accList.size();i++)
//		{
//			if(account)
//		}
//		UserManager.uList.get(log).accounts
//		accNum = 
//		return idx;
//	}

	void deleteAcc(int log, int accSel) {
		int size = UserManager.uList.get(log).accountCnt();
		int idx = 0;
		Account temp[] = new Account[size - 1];
		for (int i = 0; i < size; i++) {
			if (i != accSel) {
				temp[idx] = UserManager.uList.get(log).accounts[i];
				idx++;
			}
		}
		UserManager.uList.get(log).accounts = temp;
//		UserManager.uList.get(log).accounts[accSel] = UserManager.uList.get(log).accounts[accSel + 1];
	}

	void createAcc(int uListAccCnt, int log) {
		if (uListAccCnt < 3) {
			Account temp = new Account();
			temp.setAccNum(getAccNum());
			temp.setMoney(getMoney());
//			UserManager.uList.get(log).accounts[uListAccCnt] = temp;
			accList.add(temp);
			UserManager.uList.get(log).accounts[uListAccCnt] = accList.get(accList.size() - 1);// acclist와 연결
		} else {
			System.out.println("더 이상 만들 수 없습니다.");
		}
	}

}
