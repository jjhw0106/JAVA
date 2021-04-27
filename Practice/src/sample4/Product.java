package sample4;

public class Product {
	private int no;
	private String name;
	private int price;
	private int point;

	public Product() {
	}

	public Product(int no, String name, int price) {
		super();
		this.no = no;
		this.name = name;
		this.price = price;
		this.point = (int) (price * 0.05);
	}

	public int getNo() {
		return no;
	}

	public void setNo(int no) {
		this.no = no;
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

	public int getPoint() {
		return point;
	}

	public void setPoint(int point) {
		this.point = point;
	}

}
