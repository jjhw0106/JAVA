package collection.set;

import java.util.ArrayList;
import java.util.HashSet;
import java.util.Random;

public class HashSetApp2 {
	public static void main(String[] args) {
		HashSet<Integer> lottoNumbers = new HashSet<Integer>();
		ArrayList<Integer> lottoList = new ArrayList<Integer>();
		int[] arr = { 3, 4, 2, 3, 2, 2 };
		//

		Random ran = new Random();
		while (true) {
			if (lottoNumbers.size() >= 9)
				break;
			lottoNumbers.add(ran.nextInt(45) + 1);
			lottoList.add(ran.nextInt(45) + 1);
		}
		System.out.println(lottoList);
		System.out.println(arr);

	}
}
