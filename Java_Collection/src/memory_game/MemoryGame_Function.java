package memory_game;

import java.util.Random;
import java.util.Scanner;
import java.util.ArrayList;

class Node {
	int front;
	int back = 0;
	boolean check;
}

class MemoryGame_Function {
	ArrayList<Node> list;
	int data[];
	final int SIZE = 10;
	int cnt = 0;// 게임 클리어 조건
	Scanner sc = new Scanner(System.in);
	Random ran = new Random();

	void shuffle() {
		int idx;
		for (int i = 0; i < 1000; i++) {
			idx = ran.nextInt(data.length);
			int temp = data[0];
			data[0] = data[idx];
			data[idx] = temp;
		}

	}

	void dataInit() {
		data = new int[SIZE];
		for (int i = 0; i < SIZE; i++) {
			data[i] = (i + 2) / 2;
		}
	}

	void nodeInit() {
		list = new ArrayList<>();
		for (int i = 0; i < data.length; i++) {
			Node temp = new Node();
			temp.front = data[i];
			list.add(temp);
		}
	}

	void init() { // 캡슐화??
		dataInit();
		shuffle();
		nodeInit();
	}

	int clear() {
		int cnt = 0;
		for (int i = 0; i < data.length; i++) {
			if (list.get(i).back != 0)
				cnt++;
		}
		return cnt;
	}

	void frontToBack(int idx1, int idx2) {
		if (list.get(idx1).front == list.get(idx2).front) {
			list.get(idx1).back = list.get(idx1).front;
			list.get(idx2).back = list.get(idx2).front;
		}
	}

	void show() {
		System.out.println("==============================");
		for (int i = 0; i < data.length; i++) {
			System.out.print("[");
			if (list.get(i).back == 0) {
				System.out.print(" ");
			} else {
				System.out.print(list.get(i).back);
			}
			System.out.print("]");
		}
		System.out.println();
		System.out.println("==============================");
	}

	void show(int idx1, int idx2) {
		System.out.println("==============================");
		for (int i = 0; i < data.length; i++) {
			if (list.get(i).back == 0) {
				if (i == idx1) {
					System.out.print("[");
					System.out.print(list.get(i).front);
					System.out.print("]");
					continue;
				} else if (i == idx2) {
					System.out.print("[");
					System.out.print(list.get(i).front);
					System.out.print("]");
					continue;
				}
				System.out.print("[");
				System.out.print(" ");
				System.out.print("]");
			} else {
				System.out.print("[");
				System.out.print(list.get(i).back);
				System.out.print("]");
			}
		}
		System.out.println();
		System.out.println("==============================");
	}

	void run() {
		init();
		int idx1 = -1;
		int idx2 = -1;

		while (true) {
			if (idx1 == -1) {
				show();
			}
			else {
				show(idx1, idx2);
				System.out.println();
				try {
					Thread.sleep(1000);
					show();
				} catch (Exception e) {
				}
			}

			System.out.println();
			System.out.print("1번:");
			idx1 = sc.nextInt() - 1;
			System.out.print("2번:");
			idx2 = sc.nextInt() - 1;
			frontToBack(idx1, idx2);
			int cnt = clear();
			if (cnt == data.length) {
				System.out.println("게임 클리어!!");
				break;
			}
		}
	}
}
