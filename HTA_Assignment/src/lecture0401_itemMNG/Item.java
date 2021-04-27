package lecture0401_itemMNG;

public class Item {

	public Item(int no, String category, String name, String brand, int price) {
		this.no = no;
		this.name = name;
		this.category = category;
		this.price = price;
		this.brand = brand;
	}

	int no;
	String name;
	String category;
	String brand;
	int price;

}
