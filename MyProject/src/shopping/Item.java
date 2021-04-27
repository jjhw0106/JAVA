package shopping;

class Item {
	private String name;
	private int amount;
	private String category;

	public Item(String category, String name, int amount) {
		this.category = category;
		this.name = name;
		this.amount = amount;
	}

	public String getName() {
		return name;
	}

	public void setName(String name) {
		this.name = name;
	}

	public int getAmount() {
		return amount;
	}

	public void setAmount(int amount) {
		this.amount = amount;
	}

	public String getCategory() {
		return category;
	}

	public void setCategory(String category) {
		this.category = category;
	}

}

class Basket {
	private String id;
	private String itemName;
	private String amount;

	public Basket(String id, String itemName, String amount) {
		this.id = id;
		this.itemName = itemName;
		this.amount = amount;
	}

}

class Category {
	private String cateName;
	private int pCount;

	public Category(String cateName, int pCount) {
		this.cateName = cateName;
		this.pCount = pCount;
	}

	public String getCateName() {
		return cateName;
	}

	public void setCateName(String cateName) {
		this.cateName = cateName;
	}

	public int getpCount() {
		return pCount;
	}

	public void setpCount(int pCount) {
		this.pCount = pCount;
	}

}
