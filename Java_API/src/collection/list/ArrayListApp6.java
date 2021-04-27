package collection.list;

import java.util.ArrayList;
import java.util.Collection;
import java.util.Collections;
import java.util.Comparator;

public class ArrayListApp6 {
	public static void main(String[] args) {
		ArrayList<Product> products = new ArrayList<Product>();
		products.add(new Product(30, "태블릿", 80));
		products.add(new Product(20, "핸드폰", 50));
		products.add(new Product(40, "티비", 150));
		products.add(new Product(50, "노트북", 200));
		products.add(new Product(10, "노트북", 200));

		System.out.println("상품번호순 정렬");
		Collections.sort(products);
		for (Product item : products) {
			System.out.println(item.getNo() + "," + item.getName());
		}

		System.out.println("이름순으로 정렬");

		// Comparator<E> 인터페이스 compare(T t1, T t2) 메소드를 익명객체로 구현하기
		// 방법 1.
		Comparator<Product> nameComparator = new Comparator<Product>() {
			@Override
			public int compare(Product o1, Product o2) {
				return o1.getName().compareTo(o2.getName());
			}
		};
		Collections.sort(products, nameComparator);

		// 방법 2.
		System.out.println("가격순으로 정렬");
		Collections.sort(products, new Comparator<Product>() {
			@Override
			public int compare(Product o1, Product o2) {
				return o1.getPrice() - o2.getPrice();
			}
		});

		// 방법 3. 람다식 활용
		System.out.println("적립포인트순으로 정렬하기");
		Comparator<Product> pointComparator = (o1, o2) -> o1.getPoint() - o2.getPoint();
		Collections.sort(products, pointComparator);
		for (Product item : products) {
			System.out.println(item.getNo() + "\t" + item.getName() + "\t" + item.getPrice());
		}
		System.out.println();

		// 방법 3-1 람다, 참조변수 없이 바로 사용
		System.out.println("적립포인트순으로 정렬하기");
		Collections.sort(products, (o1, o2) -> o1.getPoint() - o2.getPoint());
		for (Product item : products) {
			System.out.println(item.getNo() + "\t" + item.getName() + "\t" + item.getPrice());
		}
		System.out.println();

	}
}
