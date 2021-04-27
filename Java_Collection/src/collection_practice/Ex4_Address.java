package collection_practice;

import java.util.ArrayList;

class Aa {
	int a;

	Aa(int a) {
		this.a = a;
	}
}

class AaManager {
	ArrayList<Aa> Aalist = new ArrayList<Aa>();
}

public class Ex4_Address {
	public static void main(String[] args) {
		AaManager am = new AaManager();
		for (int i = 0; i < 10; i++) {
			am.Aalist.add(new Aa(i));
		}

		ArrayList<Aa> test = new ArrayList<Aa>();

		for (int i = 0; i < 4; i++) {
			test.add(am.Aalist.get(i));
		}

		test.get(0).a = 100;

		for (int i = 0; i < 10; i++)
			System.out.println(am.Aalist.get(i).a);
	}
}
