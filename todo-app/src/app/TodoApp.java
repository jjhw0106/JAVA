package app;

import service.TodoService;
import static utils.KeyboardUtils.readInt;
import static utils.KeyboardUtils.readString;

import java.util.Date;

import static utils.KeyboardUtils.readDate;
import static utils.KeyboardUtils.readDateTime;

import exception.TodoException;

public class TodoApp {

	private TodoService service = new TodoService();

	public TodoApp() {
		service.프로그램시작서비스();
	}

	public void menu() {
		try {
			if (!service.로그인여부제공서비스()) {
				System.out.println(
						"---------------------------------------------------------------------------------------------------------");
				System.out.println("1.로그인 2.회원가입 0.종료");

				System.out.print("메뉴 선택 > ");
				int menuNo = readInt();
				System.out.println();

				if (menuNo == 1) {
					로그인();
				} else if (menuNo == 2) {
					회원가입();
				} else if (menuNo == 0) {
					종료();
				}

			} else {
				System.out.println(
						"---------------------------------------------------------------------------------------------------------");
				System.out.println("1.일정조회 2.일정추가 3.일정변경 4.일정완료처리 5.일정삭제 6.비밀번호변경 7.로그아웃 8.회원탈퇴  0.종료");
				System.out.println(
						"---------------------------------------------------------------------------------------------------------");

				System.out.print("메뉴 선택 > ");
				int menuNo = readInt();

				if (menuNo == 1) {
					일정조회();
				} else if (menuNo == 2) {
					일정추가();
				} else if (menuNo == 3) {
					일정변경();
				} else if (menuNo == 4) {
					일정완료처리();
				} else if (menuNo == 5) {
					일정삭제();
				} else if (menuNo == 6) {
					비밀번호변경();
				} else if (menuNo == 6) {
					로그아웃();
				} else if (menuNo == 6) {
					회원탈퇴();
				} else if (menuNo == 0) {
					종료();
				}
			}
		} catch (TodoException e) {
			System.out.println("[오류] " + e.getMessage());
		}
		System.out.println();
		System.out.println();
		System.out.println();

		menu();
	}

	// 아이디와 비밀번호를 입력받아서 로그인 서비스를 실행한다.
	private void 로그인() {
		System.out.println("[로그인]");

		System.out.print("아이디를 입력하세요: ");
		String userId = readString();

		System.out.print("비밀번호를 입력하세요: ");
		String password = readString();

		service.로그인서비스(userId, password);
		System.out.println("[안내] 로그인이 완료되었습니다.");
	}

	// 로그아웃 서비스를 실행한다.
	private void 로그아웃() {

	}

	// 아이디, 비밀번호, 사용자명을 입력받아서 회원가입 서비스를 실행한다.
	private void 회원가입() {

	}

	// 종료 서비스를 실행한다.
	private void 종료() {

	}

	// 나의모든일정조회서비스를 실행한다.
	private void 일정조회() {

	}

	// 일정제목, 내용, 예정일을 입력받아서 새일정추가서비스를 실행한다.
	private void 일정추가() {
		System.out.println("[새 일정 추가]");

		System.out.print("일정 제목을 입력하세요: ");
		String title = readString();
		System.out.print("일정 내용을 입력하세요: ");
		String text = readString();
		System.out.print("일정 실행일을 입력하세요(2021-04-30): ");
		Date day = readDate();
	}

	// 변경할 일정번호, 제목, 내용을 입력받아서 일정변경서비스를 실행한다.
	private void 일정변경() {

	}

	// 완료처리할 일정번호를 입력받아서 일정완료처리서비스를 실행한다.
	private void 일정완료처리() {

	}

	// 삭제할 일정번호를 입력받아서 일정삭제서비스를 실행한다.
	private void 일정삭제() {

	}

	// 이전비밀번호, 새비밀번호를 입력받아서 비밀번호변경서비스를 실행한다.
	private void 비밀번호변경() {

	}

	// 비밀번호를 입력받아서 회원탈퇴서비스를 실행한다.
	private void 회원탈퇴() {

	}

	public static void main(String[] args) {
		new TodoApp().menu();
	}
}
