package Scheduler_interface;

import java.io.IOException;

public class SchedulerTest {
	public static void main(String[] args) throws IOException {
		System.out.println("상담원 할당 방식을 선택하세요");
		System.out.println("R: 한명씩 차례대로");
		System.out.println("L: 대기가 적은 상담원 우선");
		System.out.println("P: 우선순위가 높은 고객우선 숙련도 높은 상담원에게");

		int ch = System.in.read();
		Scheduler scheduler = null;

		if (ch == 'r' || ch == 'R') {
			scheduler = new RoundRobin();
		} else if (ch == 'l' || ch == 'L') {
			scheduler = new LeastJob();
		} else if (ch == 'p' || ch == 'P') {
			scheduler = new Priority();
		} else {
			System.out.println("지원되지 않는 기능입니다.");
			return;
		}
		
		scheduler.getNextCall();
		scheduler.sendCallToAgent();
		
	}
}
