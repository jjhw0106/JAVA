package atm;

import java.util.ArrayList;
import java.util.Random;
import java.util.Scanner;

class AccountManager {
	Scanner sc = new Scanner(System.in);
	/*static*/ ArrayList<Account> accList = new ArrayList<Account>();
	/*static*/ int accSize = accList.size();
	Random ran = new Random();

	int[] createAccNum() {
		int accNum[] = new int[9];
		for (int i = 0; i < accNum.length; i++) {
			int rNum = ran.nextInt(10);
			accNum[i] = rNum;
		}

		return accNum;
	}

	boolean accNumCheck() {
		boolean check = true;
		for (int i = 0; i < accList.size(); i++) {
			if (accList.get(i).getAccNum() == createAccNum()) {
				check = false;
			}
		}

		return check;
	}

	Account createAccount() {
		Account temp = new Account();
		while (true) {
			System.out.print("입금액: ");
			int tempMoney = sc.nextInt();
			temp.setMoney(tempMoney);
			temp.setAccNum(createAccNum());
			if (accNumCheck() == true) {
				System.out.println("계좌생성 완료");
				accList.add(temp);
				break;
			} else {
				continue;
			}
		}
		return temp;
	}

	void deposit() {
		System.out.print("입금할 계좌를 입력하세요: ");
		int account = sc.nextInt();

	}
}
