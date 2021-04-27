package method_practice;

class Test1 {
	void printEvenOrOdd(int x) {
		if (x % 2 == 0)
			System.out.println("짝수");
		else
			System.out.println("홀수");
	}

	int sumAtoB(int x, int y) {
		int sum = 0;
		for (int i = x; i <= y; i++)
			sum += i;
		return sum;
	}

	void printPrimeNum(int x) {

		for (int i = x; i > 1; i--) {
			int check = 1;
			for (int j = i - 1; j > 1; j--) {
				if (i % j == 0)
					check = -1;
			}
			if (check == 1) {
				System.out.println(i);
			}
		}
	}
}

public class Ex1 {
	public static void main(String[] args) {
		Test1 test = new Test1();
		int a = 19;

		test.printEvenOrOdd(a);

		int num1 = 1;
		int num2 = 10;
		int sum = 0;
		sum = test.sumAtoB(num1, num2);
		System.out.println(sum);

		int prime = 20;
		test.printPrimeNum(prime);
	}

}
