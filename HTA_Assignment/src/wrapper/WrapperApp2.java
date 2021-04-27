package wrapper;

public class WrapperApp2 {
	public static void main(String[] args) {
		String value1 = "150000";
		String value2 = "3";

		int price = Integer.parseInt(value1);
		int amount = Integer.parseInt(value2);
		int total = price * amount;

		// 오류상황
//		int value3 = Integer.parseInt("");
//		int value3 = Integer.parseInt(" ");
//		int value3 = Integer.parseInt("가나다");
//		int value3 = Integer.parseInt("123가");
//		int value3 = Integer.parseInt("123 ");
//		int value3 = Integer.parseInt("3.14");
		double value4 = Double.parseDouble("3.14"); // ==> ok

	}
}
