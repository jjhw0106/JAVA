package vo;

public class Order {

	private String userId;
	private int bookNo;
	private int amount;
	
	public Order() {}
	public Order(String userId, int bookNo, int amount) {
		this.userId = userId;
		this.bookNo = bookNo;
		this.amount = amount;
	}
	public String getUserId() {
		return userId;
	}
	public void setUserId(String userId) {
		this.userId = userId;
	}
	public int getBookNo() {
		return bookNo;
	}
	public void setBookNo(int bookNo) {
		this.bookNo = bookNo;
	}
	public int getAmount() {
		return amount;
	}
	public void setAmount(int amount) {
		this.amount = amount;
	}
	
}
