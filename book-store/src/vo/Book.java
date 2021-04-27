package vo;

public class Book {

	private int no;
	private String category;
	private String title;
	private String writer;
	private String publisher;
	private int price;
	private int discountPrice;
	private int stock;
	
	public Book() {}

	public Book(int no, String category, String title, String writer, String publisher, int price, int discountPrice,
			int stock) {
		super();
		this.no = no;
		this.category = category;
		this.title = title;
		this.writer = writer;
		this.publisher = publisher;
		this.price = price;
		this.discountPrice = discountPrice;
		this.stock = stock;
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

	public String getTitle() {
		return title;
	}

	public void setTitle(String title) {
		this.title = title;
	}

	public String getWriter() {
		return writer;
	}

	public void setWriter(String writer) {
		this.writer = writer;
	}

	public String getPublisher() {
		return publisher;
	}

	public void setPublisher(String publisher) {
		this.publisher = publisher;
	}

	public int getPrice() {
		return price;
	}

	public void setPrice(int price) {
		this.price = price;
	}

	public int getDiscountPrice() {
		return discountPrice;
	}

	public void setDiscountPrice(int discountPrice) {
		this.discountPrice = discountPrice;
	}

	public int getStock() {
		return stock;
	}

	public void setStock(int stock) {
		this.stock = stock;
	}

}
