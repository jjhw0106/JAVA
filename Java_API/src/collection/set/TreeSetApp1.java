package collection.set;

import java.util.TreeSet;

public class TreeSetApp1 {
	public static void main(String[] args) {
		TreeSet<Score> scores = new TreeSet<Score>();
		scores.add(new Score("김유신", 0, 80, 50));
		scores.add(new Score("강감찬", 60, 60, 50));
		scores.add(new Score("이순신", 10, 10, 90));
		scores.add(new Score("유관순", 70, 80, 50));
		scores.add(new Score("안중근", 10, 10, 90));

		// 값이 같으면, 뒤의 데이터가 저장이 안됨 => compareTo에 이름을 기준으로 순서 추가해 줘서 해결했음
		for (Score score : scores) {
			System.out.println(score.getName());
		}
	}
}
