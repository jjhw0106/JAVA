package collection.TreeSet;

import java.util.TreeSet;
import java.util.Iterator;

public class MemberTreeSet {
	private TreeSet<Member> treeSet;

	public MemberTreeSet() {
		treeSet = new TreeSet<Member>(new Member()/*comparator사용시 반드시 선언(comparator가 구현된 객체)*/);
	}

	public void addMember(Member member) {
		treeSet.add(member);
	}

	public boolean removeMember(int memberId) {
		Iterator<Member> ir = treeSet.iterator();
		while (ir.hasNext()) {
			Member member = ir.next();
			if (member.getMemberId() == memberId) {
				treeSet.remove(member);
				return true;
			}
		}
		System.out.println(memberId + "번호가 존재하지 않습니다.");
		return false;
	}

	public void showAllMember() {
		for (Member member : treeSet) {
			System.out.println(member);
		}
		System.out.println();
	}
}
