package collection;

import java.util.LinkedList;

public class LinkedListTest {
	public static void main(String[] args) {
		LinkedList<String> myList = new LinkedList<>();

		myList.add("a");
		myList.add("b");
		myList.add("c");

		myList.add(1, "d");
		myList.removeLast();
		System.out.println((myList));// toString 제공
		
		for(int i=0; i<myList.size();i++) {
			String s = myList.get(i);
			System.out.println(s); 
		}
	}
}
