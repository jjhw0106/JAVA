package sample3;

public class Product {

	private int no;
	private String category;
	private String name;
	private int price;
	private int stock;
	private boolean isSoldOut;

	public Product() {
	}

	public Product(int no, String category, String name, int price, int stock, boolean isSoldOut) {
		super();
		this.no = no;
		this.category = category;
		this.name = name;
		this.price = price;
		this.stock = stock;
		this.isSoldOut = isSoldOut;
	}

	public int getNo() {
		return no;
	}

	public void setNo(int no) {
		this.no = no;
	}

	public String getCategory() {
		return category;
	}

	public void setCategory(String category) {
		this.category = category;
	}

	public String getName() {
		return name;
	}

	public void setName(String name) {
		this.name = name;
	}

	public int getPrice() {
		return price;
	}

	public void setPrice(int price) {
		this.price = price;
	}

	public int getStock() {
		return stock;
	}

	public void setStock(int stock) {
		this.stock = stock;
	}

	public boolean isSoldOut() {
		return isSoldOut;
	}

	public void setSoldOut(boolean isSoldOut) {
		this.isSoldOut = isSoldOut;
	}

}
