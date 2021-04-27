package collection.list;

import java.util.ArrayList;
import java.util.LinkedList;
import java.util.Queue;

public class ArrayListApp1 {
	static ArrayList<Integer> list = new ArrayList<Integer>();
	static Queue<Integer> q = new LinkedList<Integer>();

	public static void main(String[] args) {
		int num = 10;

		q.add(num += 10);
		q.add(num += 10);
		q.add(num += 10);
		q.add(num += 10);
		q.add(num += 10);
		q.add(num += 10);
		q.add(num += 10);
		q.add(num += 10);
		while (!q.isEmpty()) {
			System.out.println(q.poll());
		}

	}

}
