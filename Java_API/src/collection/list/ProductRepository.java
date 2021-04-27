package collection.list;

import java.util.ArrayList;

public class ProductRepository {
	ArrayList<Product> productList = new ArrayList<Product>();

	
	public ProductRepository() {
		productList.add(new Product(10, "맥북프로", 2_600_000)); // 숫자 이렇게 써도 됨
		productList.add(new Product(20, "애플워치", 400000));
		productList.add(new Product(30, "갤럭시워치", 300000));
		productList.add(new Product(40, "아이패드", 1200000));
		productList.add(new Product(50, "TV", 3000000));
		productList.add(new Product(60, "스피커", 120000));
		productList.add(new Product(70, "키보드", 70000));
		productList.add(new Product(80, "마우스", 25000));
		productList.add(new Product(90, "충전기", 15000));
		productList.add(new Product(100, "맥북프로", 2600000));
	}

	public void showProduct(Product product) {
		System.out.printf("%-4d\t%-4s\t  %s\t%s\n", // 질문
				product.getNo(), product.getName(),
				product.getPrice(), product.getPoint());
	}

	public void showAllProduct() {
		for (Product product : productList) {
			showProduct(product);

		}
	}

	public Product selectProductByNo(int no) {
		for (Product product : productList) {
			if (no == product.getNo())
				return product;
		}
		return null;
	}
	
}