package collection_practice;

import java.text.SimpleDateFormat;
import java.util.Date;

public class Object_Date {

	public static void main(String[] args) {

		Date date = new Date();
		SimpleDateFormat sdf1 = new SimpleDateFormat("yyyy년 MM월 dd일 E요일 a hh시 mm분 ss초");

		System.out.println(sdf1.format(date));

		long time = System.currentTimeMillis();
		System.out.println(time);
	}
}
