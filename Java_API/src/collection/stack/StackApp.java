package collection.stack;

import java.util.Scanner;
import java.util.Stack;

public class StackApp {
	public static void main(String[] args) {
		Stack<String> history = new Stack<String>();
		Scanner sc = new Scanner(System.in);
		System.out.println("Stack객체에 값 저장하기");
//		for (int i = 0; i < 5; i++) {
//			String value = sc.next();
//		history.push("1");
//		history.push("2");
//		history.push("3");
//		history.push("4");
//		history.push("5");
//		history.push("6");
//		}

		while (true) {
			System.out.println(history);
			int sel = sc.nextInt();
			if (sel == 1) {
				System.out.print("값을 입력하세요: ");
				history.push(sc.next());
			} else if (sel == 2) {
				if (history.isEmpty()) {
					System.out.println("스택이 비어있습니다");
					continue;
				}
				System.out.println(history.pop());
			}
		}
	}
}