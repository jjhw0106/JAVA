package collection;

import java.util.ArrayList;

class Queue {
	ArrayList<String> arrayQueue = new ArrayList<>();

	public void enqueue(String data) {
		arrayQueue.add(data);

	}

	public String dequeue() {
		int len = arrayQueue.size();
		if (len == 0)
			return "큐가 비어있습니다";
		return arrayQueue.remove(0);

	}

}

public class QueueTest {
	public static void main(String[] args) {
		Queue q = new Queue();
		q.enqueue("A");
		q.enqueue("B");
		q.enqueue("C");
		q.enqueue("D");

		System.out.println(q.dequeue());
		System.out.println(q.dequeue());
		System.out.println(q.dequeue());
		System.out.println(q.dequeue());
		System.out.println(q.dequeue());
	}
}
