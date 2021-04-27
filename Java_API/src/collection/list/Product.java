package collection.list;

public class Product implements Comparable<Product> {
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

	@Override
	public int hashCode() {
		final int prime = 31;
		int result = 1;
		result = prime * result + no;
		return result;
	}

	@Override
	public boolean equals(Object obj) {
		if (this == obj)
			return true;
		if (obj == null)
			return false;
		if (getClass() != obj.getClass())
			return false;
		Product other = (Product) obj;
		if (no != other.no)
			return false;
		return true;
	}

	@Override
	public int compareTo(Product p) {
		return this.getNo() - p.getNo();
	}

}