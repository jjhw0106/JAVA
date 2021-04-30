package utils;

import java.text.ParseException;
import java.text.SimpleDateFormat;
import java.util.Date;

public class StringUtils {

	private static SimpleDateFormat dateFormat = new SimpleDateFormat("yyyy-MM-dd");
	private static SimpleDateFormat dateTimeFormat = new SimpleDateFormat("yyyy-MM-dd HH:mm:ss");
	
	/**
	 * 지정된 문자열을 정수로 변경한다.
	 * @param value 숫자로 구성된 문자열 "12345"
	 * @return int형 정수
	 */
	public static int stringToInt(String value) {
		return Integer.parseInt(value);
	}
	
	/**
	 * 지정된 문자열을 boolean값으로 변경한다.
	 * @param value "true" 혹은 "false" 값 중의 하나다.
	 * @return boolean형 값
	 */
	public static boolean stringToBoolean(String value) {
		return Boolean.parseBoolean(value);
	}
	
	/**
	 * 지정된 문자열을 날짜로 변경한다.
	 * @param text 날짜패턴의 문자열 "2020-10-31"
	 * @return 날짜 정보가 포함된 Date객체, 유효하지 않은 형식인 경우 null을 반환
	 * @throws ParseException
	 */
	public static Date stringToDate(String text) {
		try {
			return dateFormat.parse(text);
		} catch (ParseException e) {
			return null;
		}
	}

	/**
	 * 지정된 문자열을 날짜로 변경한다.
	 * @param text 날짜패턴의 문자열 "2020-10-31 13:11:20"
	 * @return 날짜, 시간 정보가 포함된 Date객체, 유효하지 않은 형식인 경우 null을 반환
	 * @throws ParseException
	 */
	public static Date stringToDateTime(String text) {
		try {
			return dateTimeFormat.parse(text);
		} catch (ParseException e) {
			return null;
		}
	}
	
	/**
	 * 날짜를 문자열로 변환한다.
	 * @param date 날짜정보
	 * @return yyyy-MM-dd 형식의 문자열
	 */
	public static String dateToString(Date date) {
		if (date == null) {
			return null;
		}
		return dateFormat.format(date);
	}
	
	/**
	 * 날짜를 문자열로 변환한다.
	 * @param date 날짜정보
	 * @return yyyy-MM-dd HH:mm:ss 형식의 문자열
	 */
	public static String dateTimeToString(Date date) {
		if (date == null) {
			return null;
		}
		return dateTimeFormat.format(date);
	}
	
	/**
	 * 1초마다 변하는 일련번호를 반환한다.
	 * @return 6자리 정수
	 */
	public static int getSequence() {
		return Integer.parseInt(String.valueOf(System.currentTimeMillis()/1000).substring(4));
	}
	
}
