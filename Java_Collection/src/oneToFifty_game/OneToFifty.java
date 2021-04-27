package oneToFifty_game;

import java.util.Random;
import java.util.Scanner;
import java.util.ArrayList;

class Node1to50 {
	int num;

	void print() {
		System.out.print(num + "\t");
	}
}

class GameFunc {
	Random ran = new Random();
	Scanner sc = new Scanner(System.in);
	ArrayList<Node1to50> nodeList = new ArrayList<>();
	int board[][];
	int front[];
	int back[];

	int check;
	int idx = 0;
	int idxForInit = 0;
	int num = 1;
	final int SIZE = 3;

	//1~25(초기 세팅에 들어갈 값 초기화 및 셔플)
	void frontInit() {
		front = new int[SIZE * SIZE];
		for (int i = 0; i < SIZE * SIZE; i++) {
			front[i] = (i + 1);
		}
		for (int i = 0; i < 500; i++) {
			int rNum = ran.nextInt(SIZE * SIZE);
			int temp = front[0];
			front[0] = front[rNum];
			front[rNum] = temp;
		}
	}

	//26~50(변경될 값 초기화 및 셔플)
	void backInit() {
		back = new int[SIZE * SIZE];
		for (int i = 0; i < SIZE * SIZE; i++) {
			back[i] = SIZE * SIZE + (i + 1);
		}
		for (int i = 0; i < 500; i++) {
			int rNum = ran.nextInt(SIZE * SIZE);
			int temp = back[0];
			back[0] = back[rNum];
			back[rNum] = temp;
		}
	}

	//셔플된 front값을 node에 대입
	void nodeInit() {
		for (int i = 0; i < SIZE * SIZE; i++) {
			Node1to50 temp = new Node1to50();
			temp.num = front[idxForInit];
			idxForInit++;
			nodeList.add(temp);
		}
	}

	//초기화 메소드 캡슐화
	void init() {
		frontInit();
		backInit();
		nodeInit();
	}

	// 2차원 좌표를 1차원 위치로 변경
	int getPos() {
		System.out.print("y: ");
		int y = sc.nextInt() - 1;
		System.out.println();
		System.out.print("x: ");
		int x = sc.nextInt() - 1;

		int nodeIdx = y * SIZE + x;
		return nodeIdx;
	}

	// 선택된 노드를 변경
	int nodeChange(int nodeIdx) {
		int presentNum;
		if (nodeList.get(nodeIdx).num <= SIZE * SIZE) {
			presentNum = nodeList.get(nodeIdx).num;
			nodeList.get(nodeIdx).num = back[nodeIdx];
		} else {
			presentNum = nodeList.get(nodeIdx).num;
			nodeList.get(nodeIdx).num = 0;
		}

		return presentNum;

	}

	//게임오버조건 검사(입력받은 값과 입력해야할 값의 차례를 비교
	boolean numCheck(int presentNum, int checkNum) {
		boolean check = true;

		if (presentNum == checkNum) {
			check = true;
		} else
			check = false;
		return check;
	}

	void show() {
		for (int i = 0; i < SIZE; i++) {
			for (int j = 0; j < SIZE; j++) {
				nodeList.get(idx).print();
				idx++;
			}
			System.out.println();
		}
		idx = 0;
	}

	void run() {
		init();
		int checkNum = 1;
		while (true) {

			show();

			int nodeIdx = getPos();
			int presentNum = nodeChange(nodeIdx);
			boolean check = numCheck(presentNum, checkNum);
			checkNum++;
			if (check == false) {
				System.out.println("checkNum:" + checkNum + "presentNum: " + "" + presentNum);
				System.out.println("GameOver");
				break;
			}

			if (presentNum == SIZE * SIZE * 2) {
				System.out.println("Clear");
				break;
			}
		}

	}
}

public class OneToFifty {
	public static void main(String[] args) {
		GameFunc gf = new GameFunc();
		gf.run();
	}
}