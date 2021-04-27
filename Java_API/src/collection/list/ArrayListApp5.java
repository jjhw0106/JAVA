package collection.list;

import java.util.ArrayList;

public class ArrayListApp5 { 
	public static void main(String[] args) {
		ArrayList<Product> products = new ArrayList<Product>();
		products.add(new Product(10, "노트북", 200));
		products.add(new Product(20, "핸드폰", 50));
		products.add(new Product(30, "태블릿", 80));
		products.add(new Product(40, "티비", 150));
		products.add(new Product(50, "노트북", 200));

		System.out.println("Iterator를 이용해서 arrayList객체에 저장된 Product객체 조회하기");
	}
}
