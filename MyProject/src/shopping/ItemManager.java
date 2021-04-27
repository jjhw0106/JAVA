package shopping;

import java.util.ArrayList;

class ItemManager {
	private ItemManager() {

	}

	public static ItemManager imInstance = new ItemManager();

	public static ItemManager getInstance() {
		return imInstance;
	}

	static ArrayList<Item> itemList = new ArrayList<Item>();
	static ArrayList<Category> ctList = new ArrayList<Category>();
	static ArrayList<Basket> bList = new ArrayList<Basket>();

	// 아이템 추가
	static void itemAdd() {
		System.out.println("아이템 카테고리");
		for (int i = 0; i < ctList.size(); i++) {
			System.out.println(i+1+". " + ctList.get(i).getCateName());
		}
		int sel = Function.sc.nextInt()-1;
		String category = ctList.get(sel).getCateName();
		System.out.print("아이템 이름: ");
		String name = Function.sc.next();
		System.out.print("수량: ");
		int amount = Function.sc.nextInt();
		Item tempItem = new Item(category, name, amount);

		itemList.add(tempItem);
		FileManager.itemSave();
	}

	// 카테고리 추가
	static void categoryAdd() {
		System.out.print("카테고리 입력:");
		String name = Function.getStr();
		int num = 0;

		Category temp = new Category(name, num);
		if (Function.duplicationCheck(temp) == true) { // 중복검사 메소드 Str 받는걸로 합치기
			ctList.add(temp);
			FileManager.cateSave();
		} else {
			System.out.println("존재하는 카테고리입니다.");
		}
	}

	// 카테고리 삭제
	void categoryDelete() {

	}

}
