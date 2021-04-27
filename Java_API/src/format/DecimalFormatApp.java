package format;

import java.text.DecimalFormat;

public class DecimalFormatApp {
	public static void main(String[] args) {
		int number = 1000;
		DecimalFormat dfInteger = new DecimalFormat("#,###");
		String formattedNum = dfInteger.format(number);
		System.out.println(formattedNum);

		double number2 = 1223.12323;
//		DecimalFormat dfDouble = new DecimalFormat("#,###.##");
		DecimalFormat dfDouble = new DecimalFormat("#,###.00");
		String formattedNum2 = dfDouble.format(number2);
		System.out.println(formattedNum2);

	}
}
