package collection_practice;

import java.util.ArrayList;
import java.util.Scanner;

class Tv {
	String name;
	String brand;
	int price;

	Tv(String name, String brand, int price) {
		this.name = name;
		this.brand = brand;
		this.price = price;

	}
}

public class Ex2 {

	public static void main(String[] args) {
		ArrayList<Tv> list = new ArrayList<>();
		Tv temp = new Tv("tv", "삼성", 1000);
		list.add(temp);
		temp = new Tv("시그니처", "엘지", 2000);
		list.add(temp);
		temp = new Tv("스마트Tv", "애플", 3000);
		list.add(temp);

		temp = list.get(1);
		System.out.println(temp.name);
	}
}
