package date;

import java.util.Calendar;
import java.util.Date;

public class DateApp2 {
	public static void main(String[] args) {
		// 현재 날짜 및 시간정보를 포함하고 있는 Date객체 생성하기
		Date now = new Date();
		System.out.println(now);

		Calendar cal = Calendar.getInstance();
		System.out.println(cal);

		// 특정 날짜와 시간정보를 포함하는 Calendar 객체 생성하기
		Calendar cal2 = Calendar.getInstance();

		cal2.set(1992, 00, 06, 11, 34, 10); // 1992년 1.6 11시 34분 10초에 해당하는 정보
		System.out.println("cal2: " + cal2);

		// calendar객체에서 Date객체 조회하기
		System.out.println("cal2 date:" + cal2.getTime());

		// Calendar객체로부터 유닉스타임 조회하기
		long unixTime = cal2.getTimeInMillis();
		System.out.println("유닉스타임: " + unixTime);
		
		//유닉스타임값으로 Date객체 생성하기
		Date date2 = new Date(1000);
		System.out.println(date2);
	}
}
