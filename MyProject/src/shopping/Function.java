package shopping;

import java.util.Scanner;
import java.util.ArrayList;
import java.util.Random;

class Function {
	static Scanner sc = new Scanner(System.in);

	static String getStr() {
		String str = sc.next();
		return str;
	}

	static int getInt() {
		int i = sc.nextInt();
		return i;
	}

	
	// duplicationCheck()에 어레이리스트를 매개변수로 받아오려 했으나, 그렇게 되면 파일이 너무 무거워지므로 각각의 매니저 클래스에 메소드 따로 생성하길 권장
	static boolean duplicationCheck(Category ct) {
		boolean check = true;

		for (int i = 0; i < ItemManager.ctList.size(); i++) {
			if (ct.getCateName().equals(ItemManager.ctList.get(i).getCateName()))
				check = false;
		}

		return check;
	}
	static boolean duplicationCheck(String str, String arr[]) {
		boolean check = true;
		
		for (int i = 0; i < arr.length; i++) {
			if (str.equals(arr[i]))
				check = false;
		}
		
		return check;
	}

//	boolean duplicationCheck(User user) {
//		boolean check = true;
//		
//		for (int i = 0; i < ItemManager.ctList.size(); i++) {
//			if (ct.getCateName().equals(ItemManager.ctList.get(i).getCateName()))
//				check = false;
//		}
//		
//		return check;
//	}

}
