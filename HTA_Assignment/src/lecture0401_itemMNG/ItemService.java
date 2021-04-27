package lecture0401_itemMNG;

import java.util.Scanner;

public class ItemService {
	Scanner sc = new Scanner(System.in);
	Item[] items = new Item[100];
	int position = 0;

	ItemService() {
		items[position++] = new Item(101, "노트북", "맥북", "애플", 1900000);
		items[position++] = new Item(501, "딤채", "김치냉장고", "LG", 1900000);
		items[position++] = new Item(201, "스마트폰", "갤럭시21", "삼성", 1900000);
		items[position++] = new Item(102, "노트북", "TFX21", "한성", 1900000);
		items[position++] = new Item(119, "모니터", "휴대용모니터", "제우스", 1900000);
		// items 배열에 Item객체 5개 등록
		// items[position++] = new Item(100,"노트북","맥북","애플",1900000);
		// items 배열에 저장된 모든 Item객체의 번호, 상품명, 가격을 출력함
	}

	void printAllItems() {

	}

	void printItemsByCategory(String category) {

	}

	void printItemsByName(String name) {

	}

	void printItemsByPrice(int minPrice, int maxPrice) {

	}

	void printItemDetail(int no) {

	}

	void insertItem(Item item) {

	}

	void deleteItem(int no) {

	}
}
