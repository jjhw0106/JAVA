package object_study;

class Student {
	int studentNum;
	String studentName;

	public Student(int studentNum, String studentName) {
		this.studentNum = studentNum;
		this.studentName = studentName;
	}

	@Override
	public boolean equals(Object obj) {
		if (obj instanceof Student) {
			Student std = (Student) obj;// 다운캐스팅 해야함
			return (this.studentNum == std.studentNum);
		}
		return false;
	}

	@Override
	public int hashCode() {
		return studentNum;
	}
}

public class Equals_test {
	public static void main(String[] args) {
//		String str1 = new String("aqc");
//		String str2 = new String("aqc");
//		System.out.println(str1 == str2);// 주소가 같니?
//		System.out.println(str1.equals(str2));// 값이 같니?
//
//		Student Lee = new Student(100, "이순신");
//		Student Lee2 = Lee;
//		Student shin = new Student(100, "이순신");
//		System.out.println(Lee.hashCode());
//		System.out.println(shin.hashCode());
//		System.out.println((Lee == shin));
//		System.out.println(Lee.equals(shin));// true가 나오게 하기 위해 equals 재정의
		
		Integer i1 = 100;
		Integer i2 = 100;
		System.out.println(i1.equals(i2));
		System.out.println(i1.hashCode());
		System.out.println(i2.hashCode());
		
		System.out.println( );
	}
}
