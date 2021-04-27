package Array_Practice;

public class Ex00 {
	public static void main(String[] args) {
		
		int n = 0;
		while(n++ < 3) { 			// n : 0 1 2 -> n : 1 2 3
			System.out.println(n);  // 1 2 [3]
		}
		
		n = 0;
		while(++n < 3) { 			// n : 1 2 [3]
			System.out.println(n);  // 1 2
		}
	}

}
