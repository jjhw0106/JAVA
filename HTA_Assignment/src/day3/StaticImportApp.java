package day3;

import static java.lang.Math.*;

public class StaticImportApp {
	public static void main(String[] args) {
//		double value1 = Math.random();
//		double value2 = Math.random();
//		long value3 = Math.round(12.34);
//		double value4 = Math.floor(1.6);

		// static���� ����Ʈ�ϸ� ��ó�� ���ص� �ȴ�.
		System.out.println("������ �� : " + random());
		System.out.println("�ݿø��� ��(3.2): " + round(3.2));
		System.out.println("�ݿø��� ��(3.7): " + round(3.7));
		System.out.println("�ٴڰ� "+ floor(3.9));
		System.out.println("õ�尪 "+ ceil(3.1));
	}
}
