package megastudy_test7;

class Member {
	int no;
	int point;
	String name;
	boolean best;
}

public class Solution3 {
	public static void main(String[] args) {

		String data1 = "1001/3,1002/1,1001/3,1003/5,1004/1,1002/2";
		String data2 = "1001/이만수,1002/김철수,1003/신민아,1004/박상아";

		// data1 은 사원번호와 판매실적이다.
		// data2 는 사원번호와 이름이다.
		// 판매실적이 4이상인사원은 best를 true로 저장하세요.

		// 위데이터를 파싱 해서 Member 클래스 배열을 완성후 출력해보세요.
		Member[] memberList = null;
		String tempD2[] = data2.split(",");
		String tempD1[] = data1.split(",");
		int size = tempD2.length;
		memberList = new Member[size];
		for (int i = 0; i < size; i++) {
			String temp2[] = tempD2[i].split("/");
			memberList[i] = new Member();
			memberList[i].no = Integer.parseInt(temp2[0]);
			memberList[i].name = temp2[1];
		}

		for (int i = 0; i < tempD1.length; i++) {
			String temp1[] = tempD1[i].split("/");
			for (int j = 0; j < size; j++) {
				if (Integer.parseInt(temp1[0]) == memberList[j].no) {
					memberList[j].point += Integer.parseInt(temp1[1]);
					break;
				}
			}
		}
		for (int i = 0; i < size; i++) {
			if (memberList[i].point >= 4) {
				memberList[i].best = true;
			}
		}

		for (int i = 0; i < size; i++) {
			System.out.println(memberList[i].no + ". " + memberList[i].name + ": " + memberList[i].point + "("
					+ memberList[i].best + ")");
		}

	}

}