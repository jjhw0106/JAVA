package megastudy_test7;

import java.util.Random;

class RanNum {
	int num;
	boolean check;

}

//문제) RanNum 클래스를 활용해서 중복숫자금지 출력 
//      num에 1~5사이숫자를 랜덤으로 저장한다. (조건 중복숫자금지)
public class Solution4_AryDuplication {
	public static void main(String[] args) {
		RanNum rn[] = new RanNum[5];
		Random ran = new Random();
		for (int i = 0; i < rn.length; i++) {
			rn[i] = new RanNum();
		}

		for (int i = 0; i < rn.length; i++) {
			int rIdx = ran.nextInt(5);
			if (rn[rIdx].check == false) {
				rn[rIdx].check = true;
				rn[rIdx].num = i + 1;
			} else {
				i--;
			}
		}
		for (int i = 0; i < rn.length; i++) {
			System.out.println(rn[i].num);
			
		}

	}
}
