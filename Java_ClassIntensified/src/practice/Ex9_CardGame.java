//package practice;
//// 카드게임 
//
//// 1) 카드모양 : 다이아 , 하트 , 스페이드 , 클로버
//// 2) 숫자      :  1~10
//// 3) 총 40장이 있다. 
//// 4) 2장씩 나눠갖은 다음 , 각 카드의 숫자의 합이 큰쪽이 이긴다. (직접만들기)
//import java.util.Random;
//import java.util.Scanner;
//
//class Card {
//	int cardNum = 40;
//	Random ran = new Random();
//	String card[][] = new String[cardNum][2];
//
//	void cardInit() {
//		for (int i = 0; i < cardNum; i++) {
//			if (i < 10) {
//				card[i][0] = "♥";
//				card[i][1] = String.valueOf(i % 10 + 1);
//			} else if (i < 20) {
//				card[i][0] = "◆";
//				card[i][1] = String.valueOf(i % 10 + 1);
//			} else if (i < 30) {
//				card[i][0] = "♠";
//				card[i][1] = String.valueOf(i % 10 + 1);
//			} else if (i < 40) {
//				card[i][0] = "♣";
//				card[i][1] = String.valueOf(i % 10 + 1);
//			}
//		}
//
//	}
//
//	void shuffle() {
//		for (int i = 0; i < 500; i++) {
//			int rNum = ran.nextInt(40);
//			String temp1 = card[0][0];
//			String temp2 = card[0][1];
//			card[0][0] = card[rNum][0];
//			card[0][1] = card[rNum][1];
//			card[rNum][0] = temp1;
//			card[rNum][1] = temp2;
//		}
//	}
//}
//
//class Player {
//	int num;// 플레이어 번호
//	int getCard = 0;// 카드 몇 장인지
//	String[][] myCard;
//}
//
//class Gamble {
//	int pCnt = 0;
//
//	Card c = new Card();
//	Player p[]; // = new Player[pCnt];
//	Scanner sc = new Scanner(System.in);
//	int cardEnd = c.cardNum - 1;
//
//	void playerSet() {
//
//		System.out.println("참가인원: ");
//		pCnt = sc.nextInt();
//		this.p = new Player[pCnt];
//		for (int i = 0; i < pCnt; i++) {
//			this.p[i] = new Player();
//			this.p[i].num = i;
//		}
//
//	}
//
//	void getCard(int turn) {
//
//		if (this.p[turn].getCard == 0) {
//			p[turn].myCard = new String[1][2];
//			this.p[turn].myCard[0][0] = c.card[this.cardEnd][0];
//			this.p[turn].myCard[0][1] = c.card[this.cardEnd][1];
//			cardEnd--;
//		} else {
//
//			String[] tempShape = new String[p[turn].myCard.length];
//			String[] tempNum = new String[p[turn].myCard.length];
//			for (int i = 0; i < p[turn].myCard.length; i++) {
//				tempShape[i] = p[turn].myCard[i][0];
//				tempNum[i] = p[turn].myCard[i][1];
//			}
//			p[turn].myCard = new String[p[turn].getCard + 1][2];
//
//			if (p[turn].myCard.length != 0) {
//				for (int i = 0; i < p[turn].myCard.length; i++) {
//					System.out.println(p[turn].myCard.length);
//					p[i].myCard[i][0] = tempShape[i];
//					p[i].myCard[i][1] = tempNum[i];
//				}
//			}
//			p[turn].myCard[p[turn].getCard - 1][0] = c.card[cardEnd][0];
//			p[turn].myCard[p[turn].getCard - 1][1] = c.card[cardEnd][1];
//			cardEnd--;
//		}
//		p[turn].getCard++;
//	}
//
//	void show() {
//		for (int i = 0; i < pCnt; i++) {
//			System.out.print(p[i].num + "의 카드: ");
//			System.out.print(p[i].myCard[i][0] + " ");
//			System.out.print(p[i].myCard[i][1]);
//		}
//	}
//
//	void hit() {
//
//	}
//
//	void run() {
//		c.cardInit();
//		c.shuffle();
//		int turn = 0;
//		playerSet();
//		for (int i = 0; i < this.pCnt; i++) {
//			getCard(turn);
//		}
//	}
//}
//
//public class Ex9_CardGame {
//	public static void main(String[] args) {
//
//		Gamble play = new Gamble();
//		play.run();
//	}
//}
