package collection.list;

import java.util.ArrayList;

public class ArrayListApp2 {
	public static void main(String[] args) {
		ProductRepository repo = new ProductRepository();
		Product product = new Product(10, "맥북프로", 2_600_000);
		System.out.println(repo.productList.get(0).equals(product));
		System.out.println(repo.productList.get(0).hashCode() + "," + product.hashCode());

		
	}
}
