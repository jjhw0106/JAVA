package interface_practice;

import java.util.Collections;

public abstract class QuickSort implements Sort {

	public void ascending(int[] num, int start, int end) {

		if (start >= end)
			return;

		int pivot = start;
		int left = start + 1;
		int right = end;

		while (left <= right) {
			while (left <= end && num[left] <= num[pivot])
				left++;
			while (right >= start && num[right] >= num[pivot])
				right--;
			if (left > right) {
				int temp = num[left];
				num[left] = num[pivot];
				num[pivot] = temp;
			} else {
				int temp = num[left];
				num[left] = num[right];
				num[right] = temp;
			}
		}
		QuickSort(num, start, right - 1);
		QuickSort(num, right + 1, end);
	}

	protected abstract void QuickSort(int[] num, int start, int i);

	@Override
	public void descending(int[] num) {

	}

	@Override
	public void description() {
		System.out.println("퀵 정렬입니다. ");
	}
}
