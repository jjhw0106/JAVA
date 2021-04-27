package day6;

public class ProductApp2 {

	public static void main(String[] args) {
		Product[] products = new Product[10];
		products[0] = new Product("청바지", "S", 100000);
		products[1] = new Product("반바지", "M", 50000);
		products[2] = new Product("운동용바지", "L", 70000);
		products[3] = new Product("정장바지", "XL", 160000);
		products[4] = new Product("치마", "S", 80000);
		products[5] = new Product("스커트", "M", 120000);
		products[6] = new Product("린넨바지", "L", 30000);
		products[7] = new Product("카고바지", "XL", 200000);
		products[8] = new Product("나팔바지", "S", 110000);
		products[9] = new Product("면바지", "M", 40000);

		System.out.println("가격이 5만원 상품 출력");
		printProducts(products, new Predicate() {
			public boolean test(Product item) {
				return item.getSize().equals("S") && item.getPrice() >= 50000 && item.getPrice() < 100000;
			}
		});

		// 람다식
		System.out.println("#### 사이즈가 XL인 상품만 출력");
		printProducts(products, item -> item.getSize().equals("XL"));
	}

	// 상품의 사이즈가 S면 true를 반환하는 익명객체

	/* static */ interface Predicate {
		boolean test(Product item);
	}

	Predicate p1 = new Predicate() {
		public boolean test(Product item) {
			return item.getSize().equals("S");
		}
	};
	Predicate p2 = new Predicate() {
		public boolean test(Product item) {
			return item.getPrice() == 50000;
		}
	};

	public static void printProducts(Product[] items, Predicate p) {
		for (Product item : items) {
			if (p.test(item)) {
				System.out.println(item.getName() + item.getSize() + item.getPrice());
			}
		}
	}

}
