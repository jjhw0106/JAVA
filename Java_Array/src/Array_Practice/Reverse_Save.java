package Array_Practice;

public class Reverse_Save {
	public static void main(String[] args) {
		int arr[] = { 10, 20, 30, 40, 50 };

		int temp4[] = new int[5];

		int i;
		for (i = 0; i < 5; i++)
		{
			temp4[4 - i] = arr[i];
		}

		for (i = 0; i < 5; i++)
			System.out.println(temp4[i]);

	}
}
