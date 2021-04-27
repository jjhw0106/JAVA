package day6;

public class ProductApp {
	// 배열과 사이즈를 전달받아서 사이즈에 해당하는 상품만 출력하기
		public static void printProductsBySize(Product[] items, String size) {
			for (Product item : items) {
				if (item.getSize().equals(size)) {
					System.out.println(item.getName() + ", " + item.getSize() + ", " + item.getPrice());
				}
			}
		}
		
		// 배열과 가격을 전달받아서 가격에 해당하는 상품만 출력하기
		public static void printProductsByPrice(Product[] items, int price) {
			for (Product item : items) {
				if (item.getPrice() == price) {
					System.out.println(item.getName() + ", " + item.getSize() + ", " + item.getPrice());
				}
			}
		}
		
		// 배열과 최소가격, 최대가격을 전달받아서 해당 가격범위에 속하는 상품만 출력하기
		public static void printProductsByPriceRange(Product[] items, int minPrice, int maxPrice) {
			for (Product item : items)
			if (item.getPrice() >= minPrice && item.getPrice() <= maxPrice) {
				System.out.println(item.getName() + ", " + item.getSize() + ", " + item.getPrice());
			}
			
		}
		
		// 배열과 사이즈, 최소가격, 최대가격을 전달받아서 해당 사이즈에 속하고, 해당 가격범위에 속하는 상품만 출력하기
		public static void printProductsBySizeAndPriceRange(Product[] items, String size, int minPrice, int maxPrice) {
			for (Product item : items) {
				if (item.getSize().equals(size) && item.getPrice() >= minPrice && item.getPrice() <= maxPrice) {
				System.out.println(item.getName() + ", " + item.getSize() + ", " + item.getPrice());
				}
			}
			
		}
		
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
			
			// 사이즈가 S인 바지만 화면에 출력하기
			printProductsBySize(products, "S");
			printProductsBySize(products, "M");
			
			// 가격이 15000이상인 바지만 화면에 출력하기
			
			// 사이즈가 M이고 가격이 1만원 이상 5만원이하인 바지만 화면에 출력하기
			
			// 
		}

	}