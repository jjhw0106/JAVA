package format;

import java.text.SimpleDateFormat;
import java.util.Date;
import java.util.Locale;

public class DateFormatApp {
	public static void main(String[] args) {
		Date today = new Date();
		SimpleDateFormat sdfDefault = new SimpleDateFormat("a h m s");// 아무것도 안정하면 운영체제의 언어 정보가 반영된다
		SimpleDateFormat sdfJapan = new SimpleDateFormat("a h m s", Locale.JAPAN);

		String todayPrint1 = sdfDefault.format(today);
		String todayPrint2 = sdfJapan.format(today);
		System.out.println(todayPrint1);
		System.out.println(todayPrint2);
	}
}
