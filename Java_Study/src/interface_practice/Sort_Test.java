package interface_practice;

import java.io.IOException;
import java.util.Scanner;

public class Sort_Test {
	public static void main(String[] args) throws IOException {
		Scanner sc = new Scanner(System.in);

		int[] num = new int[5];

		System.out.println("B: BubbleSort");
		System.out.println("Q: QuickSort");
		System.out.println("H: "
				+ "HeapSort");

		int sel = System.in.read();
		for (int i = 0; i < 5; i++) {
			System.out.print((i + 1) + ". ");
			num[i] = sc.nextInt();
		}

		Sort s = null;

		if (sel == 'B' || sel == 'b') {
			s = new BubbleSort();
		} 
//		else if (sel == 'Q' || sel == 'q') {
//			s = new QuickSort(num, 0, num.length-1);
//		} 
		else if (sel == 'H' || sel == 'h') {
			s = new BubbleSort();
		} else
			System.out.println("목록에 없습니다.");

		s.ascending(num);
		System.out.println("오름차순: ");
		for (int i : num) {
			System.out.print(i + " ");
		}
		System.out.println();
		System.out.println("내림차순: ");
		s.descending(num);
		for (int i : num) {
			System.out.print(i + " ");
		}
		s.description();

	}
}
