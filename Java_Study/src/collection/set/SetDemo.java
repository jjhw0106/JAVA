package collection.set;

import java.util.HashSet;
import java.util.Iterator;
import java.util.Set;

public class SetDemo {
	public static void main(String[] args) {

		HashSet<Integer> a = new HashSet<>();
		a.add(1);
		a.add(2);
		a.add(3);

//		HashSet<Integer> b = new HashSet<>();
//		b.add(3);
//		b.add(4);
//		b.add(5);
//
//		HashSet<Integer> c = new HashSet<>();
//		c.add(1);
//		c.add(2);

//		a.addAll(b);// b의 모든 요소를 a에 담아라(합집합)
//		a.retainAll(b); // retain 간직하다 =>a에도 있고 b에x도 있는 값들만 a에 담겠다.(교집합)
//		a.removeAll(b);(차집합)
		Iterator hi = (Iterator) a.iterator();
		while (hi.hasNext()) {
			System.out.println(hi.next());
		}
	}

}
