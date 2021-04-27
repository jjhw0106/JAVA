package practice;

class Product {
	String name;
	int price;
}

public class Ex1 {
	public static void main(String[] args) {
		Product pr = new Product();
		pr.name = "감자깡";
		pr.price = 1000;

		Product[] prList = new Product[2];
		prList[0] = new Product();
		prList[1] = new Product();

		prList[0].price = 10;
		prList[1].price = 20;

		prList[0].name = "새우깡";
		prList[1].name = "고래밥";
	}
}
