package mini_project;

import java.io.BufferedReader;
import java.io.File;
import java.io.FileReader;
import java.io.FileWriter;
import java.io.IOException;
import java.nio.Buffer;
import java.util.Random;
import java.util.Scanner;

public class Console_Board {

	public static void main(String[] args) {
		Scanner sc = new Scanner(System.in);
		/*
		 * # 콘솔 게시판
		 * 1. [이전] 또는 [이후] 버튼을 누르면 페이지 번호가 변경된다.
		 * 2. 현재 페이지 번호에 해당되는 게시글만 볼 수 있다.
		 * 3. 2차원 배열 board에 0열에는 제목을 1열에는 게시글의 내용을 저장한다.
		 * 4. 게시글을 추가하고 삭제할 때마다 파일입출력을 통해 데이터가 바로바로 저장된다.
		 * 5. 실행시 저장되어 있는 파일이 존재한다면, 바로 파일을 불러오도록 설계한다.
		 */

		int fullSize = 0;
		int size = 0;
		int num = 1;
		int curPage = 0;
//		int cnt = 0;
		int aIdx = 0;
		String[][] board = new String[size][2];
		String article[] = null;

		final String PREV = "q";
		final String NEXT = "w";
		final String EDIT = "e";
		final String REMOVE = "r";
		final int PAGESIZE = 4;

		while (true) { // 전체 콘솔창

			// 게시글 개수 구하기 && article변수에 기사 제목 삽입
			int cnt = 0;
			size = 0;
			num = 1;
			fullSize = 0;
			while (fullSize < 50) {
				String title = "게시글" + num + ".txt";
				File file = new File(title);
				if (file.exists()) {
					size++;
					String temp[] = article;
					article = new String[size];
					if (temp != null) {
						for (int i = 0; i < cnt; i++)
							article[i] = temp[i];
					}
					article[cnt] = title;
					cnt++;
					aIdx = num;
					fullSize++;
				} else
					fullSize++;
				num++;
//				file = null;
			}
			System.out.println("aIdx:" + aIdx);
			board = new String[size][2];

			// 게시글 이름 저장

			String fileName[] = new String[size];
			for (int i = 0; i < size; i++)
				fileName[i] = article[i];

			// 페이지 출력
			if ((curPage + 1) * PAGESIZE < size)
				for (int i = curPage * PAGESIZE; i < curPage * PAGESIZE + PAGESIZE; i++)
					System.out.println(((i + 1) - curPage * PAGESIZE) + "." + fileName[i]);
			else if ((curPage + 1) * PAGESIZE >= size)
				for (int i = curPage * PAGESIZE; i < curPage * PAGESIZE + (size - curPage * PAGESIZE); i++)
					System.out.println(((i + 1) - curPage * PAGESIZE) + "." + fileName[i]);
			System.out.println("========" + (curPage + 1) + " 페이지" + "========");
			System.out.println("q. 이전페이지 / w. 다음페이지");
			System.out.println("e. 글쓰기 / r. 글 삭제");

			// manage에 게시글n 집어넣기
			File manage = new File("기사 관리.txt");
			FileWriter fw = null;
			try {
				fw = new FileWriter(manage);
				for (int i = 0; i < size; i++) {
					fw.write(fileName[i]);
					if (i != size - 1)
						fw.write("\n");
				}

				fw.close();
			} catch (Exception e) {
				e.printStackTrace();
			}

			// 불러오기
			FileReader fr = null;
			BufferedReader br = null;
			try {
				String data[][] = new String[size][2];
				fr = new FileReader(manage);
				br = new BufferedReader(fr);
				for (int i = 0; i < size; i++)
					data[i][0] = br.readLine();
				fr.close();
				br.close();
				for (int i = 0; i < size; i++)
					board[i][0] = data[i][0];

				for (int i = 0; i < size; i++) {
					fr = new FileReader(article[i]);
					br = new BufferedReader(fr);
					board[i][1] = br.readLine();
					fr.close();
					br.close();

				}
			} catch (Exception e) {
				e.printStackTrace();
			}

			// 페이지 동작 // q.범위 밖의 int는 되는데 문자는 왜 오류 나는지(e,f...)
			String sel = sc.next();
			if (sel.equals(PREV)) {
				if (curPage != 0)
					curPage--;
				else
					continue;
			} else if (sel.equals(NEXT)) {
				if ((curPage + 1) * PAGESIZE < size)
					curPage++;
				else
					continue;
			}

			// 글쓰기
			else if (sel.equals(EDIT)) {

				fw = null;
				try {
					aIdx++;
					String aTitle = "게시글" + (aIdx) + ".txt";

					fw = new FileWriter(aTitle);
					System.out.println("기사 내용 입력: ");
					String aContents = sc.next();
					fw.write(aContents);
					fw.close();
				} catch (Exception e) {
					e.printStackTrace();
				}

			}

			// 글 삭제 //q. 파일 이름바꾸기 or 삭제 함수사용 -> 번호로 삭제하려 했으나 기사 번호로 삭제하는걸로
			else if (sel.equals(REMOVE)) {
				System.out.println("삭제할 게시글의 번호를 입력하세요 : ");
				int dIdx = sc.nextInt();
				System.out.println(dIdx);
				File file = null;
				try {
					file = new File("게시글" + dIdx + ".txt");
					if (file.exists())
						file.delete();
//					fw = new FileWriter("게시글" + (curPage * PAGESIZE + dIdx));

				} catch (Exception e) {
					e.printStackTrace();
				}
			}

			// 기사 선택
			else if (Integer.parseInt(sel) > 0 && Integer.parseInt(sel) <= PAGESIZE) {
				System.out.println(board[curPage * PAGESIZE + Integer.parseInt(sel) - 1][1]);
			}

		} // 전체 콘솔창
	}
}