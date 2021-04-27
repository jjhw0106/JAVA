package interface_practice;

public class BubbleSort implements Sort {

	@Override
	public void ascending(int[] num) {
		for (int i = 0; i < num.length; i++) {
			for (int j = i; j < num.length; j++) {
				if (num[i] > num[j]) {
					int temp = num[i];
					num[i] = num[j];
					num[j] = temp;
				}
			}
		}
	}

	@Override
	public void descending(int[] num) {
		for (int i = 0; i < num.length; i++) {
			for (int j = i; j < num.length; j++) {
				if (num[i] < num[j]) {
					int temp = num[i];
					num[i] = num[j];
					num[j] = temp;
				}
			}
		}
	}
	public void description() {
		System.out.println("버블정렬입니다.");
	}
}
