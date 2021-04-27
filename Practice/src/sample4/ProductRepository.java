package sample4;

public class ProductRepository {
	Product[] products = new Product[10];

	public ProductRepository() {
		products[0] = new Product(10, "맥북프로", 2_600_000); // 숫자 이렇게 써도 됨
		products[1] = new Product(20, "애플워치", 400000);
		products[2] = new Product(30, "갤럭시워치", 300000);
		products[3] = new Product(40, "아이패드", 1200000);
		products[4] = new Product(50, "TV", 3000000);
		products[5] = new Product(60, "스피커", 120000);
		products[6] = new Product(70, "키보드", 70000);
		products[7] = new Product(80, "마우스", 25000);
		products[8] = new Product(90, "충전기", 15000);
		products[9] = new Product(100, "맥북프로", 2600000);
	}

	public void showProduct(Product product) {
		System.out.printf("%-4d\t%-4s\t  %s\t%s\n", // 질문
				product.getNo(), product.getName(),
				App.df1.format(product.getPrice()), App.df1.format(product.getPoint()));
	}

	public void showAllProduct() {
		for (Product product : products) {
			showProduct(product);

		}
	}

	public Product selectProductByNo(int no) {
		for (Product product : products) {
			if (no == product.getNo())
				return product;
		}
		return null;
	}
}
