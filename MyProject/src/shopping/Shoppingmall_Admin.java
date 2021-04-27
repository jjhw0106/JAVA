package shopping;

public class Shoppingmall_Admin {
	void run() {
		if (FileManager.categoryFile.exists()) {
			FileManager.cateLoad();
		}
		while (true) {
			//추후 구현
//			System.out.println("관리자 번호를 입력하세요");
//			int adminNo = Function.getInt();
			//
			
			System.out.println("==========Shopping Mall==========");
			System.out.println("1. 카테고리 추가");
			System.out.println("2. 카테고리 삭제");
			System.out.println("3. 아이템 추가");
			System.out.println("4. 아이템 삭제");
			
			System.out.println("=================================");
			int sel = Function.sc.nextInt();
			if (sel == 1) {
				ItemManager.categoryAdd();
			} else if (sel == 2) {
			} else if (sel == 3) {
				ItemManager.itemAdd();
				

			}
		}
	}
}
