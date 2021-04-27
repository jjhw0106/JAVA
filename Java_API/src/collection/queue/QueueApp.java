package collection.queue;

import java.util.LinkedList;
import java.util.Queue;
import java.util.Scanner;

public class QueueApp {
	public static void main(String[] args) {
		Scanner sc = new Scanner(System.in);
		Queue<Integer> q = new LinkedList<Integer>();
		while (true) {
			System.out.println(q);
			System.out.println("1.값 추가  2.값 출력");

			int sel = sc.nextInt();
			if (sel == 1) {
				System.out.print("추가할 값:");
				q.offer(sc.nextInt());	//add와 차이는 없다
			} else if (sel == 2) {
				if (q.isEmpty()) {
					System.out.println("큐가 비어있습니다.");
				}
				System.out.println("꺼내진 값: " + q.poll());
			}
		}
	}
}
