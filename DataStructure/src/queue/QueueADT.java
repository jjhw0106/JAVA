package queue;

import java.util.Scanner;

class ArrayQueue {
	private int front;
	private int rear;
	private int queueSize;
	private char itemArray[];

	public ArrayQueue(int queueSize) {
		front = -1;
		rear = -1;
		this.queueSize = queueSize;
		itemArray = new char[queueSize];
	}

	public boolean isEmpty() {
		return (front == rear);
	}

	public boolean isFull() {
		return (rear == this.queueSize - 1);
	}

	public void enqueue(char item) {
		if (isFull()) {
			System.out.println("더 이상 삽입할 수 없습니다.");
		} else {
			rear++;
			itemArray[rear] = item;
		}
	}

	public char dequeue() {
		if (isEmpty()) {
			System.out.println("삭제할 데이터가 없습니다");
			return 0;
		} else {
			front++;
			return itemArray[front];
		}
	}

	public char peek() {
		if (isEmpty()) {
			System.out.println("데이터가 없습니다");
			return 0;
		} else {
			System.out.println(itemArray[front+1]);
			return itemArray[front + 1];
		}

	}

	public void printQueue() {
		for (int i = front + 1; i < queueSize; i++) {
			System.out.println(itemArray[i]);
		}

	}
}

public class QueueADT {
	public static void main(String[] args) {

		Scanner sc = new Scanner(System.in);
		int queueSize = sc.nextInt();
		ArrayQueue q = new ArrayQueue(queueSize);
		//test
		q.enqueue('a');
		q.enqueue('b');
		q.enqueue('c');
		q.enqueue('d');
		while (true) {
			int sel = sc.nextInt();
			if (sel == 1) {
				q.dequeue();
			} else if (sel == 2) {
				q.peek();
			} else if (sel == 3)
				break;
		}
		q.printQueue();
	}
}