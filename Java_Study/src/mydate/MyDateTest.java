package mydate;

public class MyDateTest {
	int year;
	int month;
	int day;

	public static void main(String[] args) {

		MyDate date1 = new MyDate(10, 12, 2020);
		MyDate date2 = new MyDate(10, 12, 2020);

		System.out.println(date1.equals(date2));
		System.out.println(date1.hashCode());
		System.out.println(date2.hashCode());
	}
}

class MyDate {

	int day;
	int month;
	int year;

	public MyDate(int day, int month, int year) {
		this.day = day;
		this.month = month;
		this.year = year;
	}

	@Override
	public boolean equals(Object obj) {
		if (obj instanceof MyDate) {
			MyDate md = (MyDate) obj;
			return (this.year == md.year && this.month == md.month && this.day == md.day);
		}
		return false;
	}

	@Override
	public int hashCode() {
		return this.year + this.month + this.day;
	}

}