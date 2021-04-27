package collection.collections;

import java.util.ArrayList;
import java.util.Collections;

class Computer implements Comparable {
	int serial;
	String owner;

	Computer(int serial, String owner) {
		this.serial = serial;
		this.owner = owner;
	}

	@Override
	public int compareTo(Object o) {
		return this.serial - ((Computer) o).serial;
	}

}

public class CollectionsDemo {
	public static void main(String[] args) {

	}
}
