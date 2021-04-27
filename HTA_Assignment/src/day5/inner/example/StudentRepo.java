package day5.inner.example;

//import day5.inner.example.GameRepo.GameStats;

public class StudentRepo {
	private Student[] students = new Student[5];

	public StudentRepo() {
		students[0] = new Student("홍길동", 50, 100, 60);
		students[1] = new Student("김유신", 100, 70, 80);
		students[2] = new Student("강감찬", 90, 40, 70);
		students[3] = new Student("이순신", 80, 90, 90);
		students[4] = new Student("류관순", 70, 100, 60);
	}

	public Stats getStats() {
		return new StudentStat();
	}

	class StudentStat implements Stats {
		@Override
		public int average() {
			int sum = this.total();
			return sum / (3 * students.length);
		}

		@Override
		public int total() {
			int sum = 0;
			for (Student student : students) {
				sum += student.kor;
				sum += student.eng;
				sum += student.math;
			}
			return sum;
		}
	}
}
