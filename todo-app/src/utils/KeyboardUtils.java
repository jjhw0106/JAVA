package utils;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.Date;

import exception.TodoException;

public class KeyboardUtils {

	private static BufferedReader reader = new BufferedReader(new InputStreamReader(System.in));
	
	/**
	 * 키보드 입력을 읽어서 문자열로 반환한다.
	 * @return 문자열
	 */
	public static String readString() {
		try {
			return reader.readLine();
		} catch (IOException e) {
			throw new RuntimeException(e);
		}
	}
	
	/**
	 * 키보드 입력을 읽어서 정수로 반환한다.
	 * @return 정수값
	 */
	public static int readInt() {
		try {
			return Integer.parseInt(reader.readLine());
		} catch (IOException | NumberFormatException e) {
			throw new RuntimeException(e);
		}
	}
	
	/**
	 * 키보드 입력을 읽어서 정수로 반환한다.
	 * @return 정수값
	 */
	public static long readLong() {
		try {
			return Long.parseLong(reader.readLine());
		} catch (IOException | NumberFormatException e) {
			throw new RuntimeException(e);
		}
	}
	
	/**
	 * 키보드 입력을 읽어서 실수로 반환한다.
	 * @return 실수값
	 */
	public static double readDouble() {
		try {
			return Double.parseDouble(reader.readLine());
		} catch (IOException | NumberFormatException e) {
			throw new RuntimeException(e);
		}
	}
	
	/**
	 * 키보드 입력을 읽어서 불린값을 반환한다.
	 * @return 불린값
	 */
	public static boolean readBoolean() {
		try {
			return Boolean.parseBoolean(reader.readLine());
		} catch (IOException | NumberFormatException e) {
			throw new RuntimeException(e);
		}
	}
	
	/**
	 * 키보드 입력을 읽어서 Date로 반환한다.<br />
	 * 입력예: 2021-04-30
	 * @return 날짜 정보를 포함하고 있는 Date객체(시간은 0시 0분 0초다.)
	 */
	public static Date readDate() {
		try {
			return StringUtils.stringToDate(reader.readLine());
		} catch (IOException e) {
			throw new TodoException("키보드입력값을 읽어올 수 없습니다.");
		}
	}
	
	/**
	 * 키보드 입력을 읽어서 Date로 반환한다.
	 * 입력예: 2021-04-30 13:23:50
	 * @return 날짜와 시간정보를 포함하고 있는 Date객체
	 */
	public static Date readDateTime() {
		try {
			return StringUtils.stringToDateTime(reader.readLine());
		} catch (IOException e) {
			throw new TodoException("키보드입력값을 읽어올 수 없습니다.");
		}
	}
	
}
