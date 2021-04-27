package interface_practice;

public interface Sort {
	void ascending(int[] num);
	void descending(int[] num);
	default void description() {
		System.out.println("정렬입니다.");
	}
}
