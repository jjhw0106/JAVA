package assignmentExtra;

public class Sum {
	public static void main(String[] args) {
		int a = 12345;
		int divisor = 10;
		int answer = 0;

		while (true) {
			if (a == 0) {
				break;
			}
			answer += (a % divisor);
			a /= divisor;
		}
		System.out.println(answer);
	}
}
