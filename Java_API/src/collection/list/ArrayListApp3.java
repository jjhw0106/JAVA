package collection.list;

import java.util.ArrayList;
import java.util.Iterator;

public class ArrayListApp3 {
	public static void main(String[] args) {
		ArrayList<String> names = new ArrayList<String>();

		names.add("김유신");
		names.add("강감찬");
		names.add("이순신");
		names.add("유관순");
		names.add("유관순");
		names.add("안창호");
		names.add("안중근");

		// 오류 => enhanced for문으로 반복하는 와중에 데이터를 삭제할 순 없다.
//		for (String name : names) {
//			if (name.contains("안")) {
//				names.remove(name);
//			}
//		}

		// 이것도 오류임-> 안씨가 붙어있으면 하나 씹힘(List가 땡겨지기 때문)
//		for (int i = 0; i < names.size(); i++) {
//			if (names.get(i).contains("안")) {
//				names.remove(i);
//				System.out.println(i);
//			}
//		}

		Iterator<String> iter = names.iterator();
		while (iter.hasNext()) {
			if (iter.next().startsWith("안")) {
				iter.remove();
			}
		}
		//Iterator는 일회성이라 이 밑으로는 iter를 사용할 수 없다.
		//다시 사용하려면 새롭게 iter를 주어야 한다.
		
		iter = names.iterator();
		while (iter.hasNext()) {
			System.out.println(iter.next());
		}
		

		for (String string : names) {
			System.out.println(string);
		}

	}
}
