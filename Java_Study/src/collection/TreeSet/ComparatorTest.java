package collection.TreeSet;

import java.util.Comparator;
import java.util.TreeSet;

class MyCompare implements Comparator<String>{

	@Override
	public int compare(String o1, String o2) {
		
		return o1.compareTo(o2)*-1;
	}
	
}

public class ComparatorTest {
	public static void main(String[] args) {
		TreeSet<String> treeSet = new TreeSet<String>(new MyCompare());
		treeSet.add("홍길동");
		treeSet.add("강감찬");
		treeSet.add("이순신");

		for (String str : treeSet)
			System.out.println(str);
	}
} 
