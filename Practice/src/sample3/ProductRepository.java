package sample3;

public class ProductRepository {
	Product[] products = new Product[10];

	public ProductRepository() {
		products[0] = new Product(10, "노트북", "맥북에어", 1700000, 5, false);
		products[1] = new Product(20, "노트북", "맥북프로", 2700000, 10, false);
		products[2] = new Product(30, "노트북", "LG그램", 1900000, 40, false);
		products[3] = new Product(40, "스마트폰", "샤오미", 600000, 30, false);
		products[4] = new Product(50, "스마트폰", "아이폰12", 1700000, 30, false);
		products[5] = new Product(60, "스마트폰", "갤럭시S20", 1500000, 100, false);
		products[6] = new Product(70, "시계", "갤럭시워치", 470000, 0, true);
		products[7] = new Product(80, "시계", "애플워치6", 700000, 5, false);
		products[8] = new Product(90, "도서", "자바의 정석", 35000, 100, false);
		products[9] = new Product(100, "도서", "이것이 자바다", 28000, 100, false);
	}

	public void showProductInform(Product product) {
		System.out.println("상품번호: " + product.getNo() +
				", 카테고리: " + product.getCategory() +
				", 상품명: " + product.getName() +
				", 가격: " + product.getPrice() +
				", 재고: " + product.getStock() +
				", 품절여부: " + (product.isSoldOut() == true ? "품절" : "재고있음"));
	}

	public void showAllProduct() {
		for (Product product : products) {
			showProductInform(product);
		}
	}
	
	//활용해보기 - category.isBlank() => 카테고리가 비어있거나 길이가 0이면 true 
	public boolean showByCategory(String category) {
		boolean check = false;
		for (Product product : products) {
			if (product.getCategory().equals(category)) {
				showProductInform(product);
				check = true;
			}
		}
		return check;
	}

	public boolean showByName(String name) {
		boolean check = false;
		for (Product product : products) {
			if (product.getName().contains(name)) {
				showProductInform(product);
				check = true;
			}
		}
		return check;
	}

	public boolean showByPrice(int minimum, int maximum) {
		boolean check = false;
		for (Product product : products) {
			if (product.getPrice() >= minimum && product.getPrice() <= maximum) {
				showProductInform(product);
				check = true;
			}
		}
		return check;
	}

	public Product pickUp(int no) {
		for (Product product : products) {
			if (product.getNo() == no) {
				if (product.getStock() == 0) {
					System.out.println("재고부족");
					break;
				}
				product.setStock(product.getStock() - 1);
				return product;
			}
		}
		return null;
	}

}