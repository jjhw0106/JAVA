
package megastudy_test7;

import java.util.Random;
import java.util.Scanner;

class Card {
	Random ran = new Random();
	String card[][];
	int endIdx;
	final int CARDDECK = 40;
	int set = 1;

//♠♥♣◆
	void cardInit() {
		card = new String[CARDDECK * set][2];
		endIdx = CARDDECK * 1 - 1;
		int shapeCnt = CARDDECK * set / 4;
		for (int i = 0; i < shapeCnt; i++) {
			card[0 * shapeCnt + i][0] = "♠";
			card[0 * shapeCnt + i][1] = String.valueOf((i + 1));
			card[1 * shapeCnt + i][0] = "♥";
			card[1 * shapeCnt + i][1] = String.valueOf((i + 1));
			card[2 * shapeCnt + i][0] = "♣";
			card[2 * shapeCnt + i][1] = String.valueOf((i + 1));
			card[3 * shapeCnt + i][0] = "◆";
			card[3 * shapeCnt + i][1] = String.valueOf((i + 1));

		}
	}

	void cardShuffle() {
		for (int i = 0; i < 1000; i++) {
			String tempShape = card[0][0];
			String tempNum = card[0][1];

			int idx = ran.nextInt(CARDDECK * set);

			card[0][0] = card[idx][0];
			card[0][1] = card[idx][1];

			card[idx][0] = tempShape;
			card[idx][1] = tempNum;
		}
	}

}

class Player {
	String myCard[][];
	int cardCnt = 0;
	int sum = 0;
	boolean dead;
	int win = -1;
}

class BlackJackPlay {
	Scanner sc = new Scanner(System.in);
	Card cardDeck = new Card();
	String dealer[][];
	int playerNum = 0;
	int turn = 0;

	void hit() {

	}

	int getCard(Player p) {// q. Player p 일때랑 Player p[] 일때랑 의미하는바?

		String get[] = new String[2];
		get[0] = cardDeck.card[cardDeck.endIdx][0];// shape
		get[1] = cardDeck.card[cardDeck.endIdx][1];// number
		cardDeck.endIdx--;
		p.cardCnt++;
		p.sum += Integer.parseInt(get[1]);
		if (p.myCard == null) {
			p.myCard = new String[p.cardCnt][2];
			p.myCard[0][0] = get[0];
			p.myCard[0][1] = get[1];
		} else {
			String temp[][] = p.myCard;
			p.myCard = new String[p.cardCnt][2];
			p.myCard[p.cardCnt - 1][0] = get[0];
			p.myCard[p.cardCnt - 1][1] = get[1];
			for (int j = 0; j < temp.length; j++) {
				p.myCard[j][0] = temp[j][0];
				p.myCard[j][1] = temp[j][1];
			}
		}
		return Integer.parseInt(get[1]);
	}

	void show() {
		for (int i = 0; i < playerNum; i++) {

		}
	}

	void run() {
		while (true) {
			System.out.println("참가 인원: ");
			playerNum = sc.nextInt();
			if (playerNum < 6)
				break;
			else
				System.out.println("최대 참여인원은 5명입니다.");
		}
		Player player[] = new Player[playerNum];
		for (int i = 0; i < playerNum; i++) {
			player[i] = new Player();
		}
		cardDeck.cardInit();
		cardDeck.cardShuffle();

		// 처음 두 장 받기
		for (int k = 0; k < 2; k++) {
			for (int i = 0; i < playerNum; i++) {
				getCard(player[i]);

			}
		}

		while (true) {
			System.out.println("===========================");
			for (int i = 0; i < playerNum; i++) {
				if (i == 0) {
					System.out.print("dealer: ");
				} else
					System.out.print("플레이어" + i + ": ");
				for (int j = 0; j < player[i].cardCnt; j++) {
					System.out.print(player[i].myCard[j][0]);
					System.out.print(player[i].myCard[j][1]);
					System.out.print(" ");
				}
				System.out.print(" - 합계: " + player[i].sum);
				if (player[i].dead == true) {
					System.out.print("(Bust!!)");
				}
				if (player[i].win == 1) {
					System.out.print("(Win!!)");
				}else if(player[i].win ==0)
					System.out.println("Draw!");
				if (i == 0)
					System.out.println();
				System.out.println();
			}
			System.out.println("===========================");

			// Hit or Stay
			if (turn == playerNum) {
				break;
			}
			if (player[0].dead == true) {
				break;
			}
			int hit = 0;
			if (turn == 0) {
				if (player[0].sum <= 16) {
					try {
						Thread.sleep(300);
					} catch (Exception e) {
						// TODO: handle exception
					}
					System.out.println("딜러 Hit");
					hit = 1;
				} else {
					System.out.println("딜러 Stay");
					hit = 2;
				}
			} else {
				System.out.println(turn + "플레이어>Hit or Stay");
				hit = sc.nextInt();
			}

			if (hit == 1) {
				player[turn].sum += getCard(player[turn]);
				if (player[turn].sum > 21) {
					player[turn].dead = true;
					turn++;
				} else {
					continue;
				}
			} else if (hit == 2) {
				turn++;
			}
			if (player[0].dead == true) {
				System.out.println("딜러 Bust!!!");
				for (int i = 1; i < playerNum; i++) {
					player[i].win = 1;
				}
			} else {
				for (int i = 1; i < playerNum; i++)
					if (player[0].sum < player[i].sum && player[i].dead == false) {
						player[i].win = 1;
					} else if (player[0].sum == player[i].sum && player[i].dead == false) {
						player[i].win = 0;
					}
			}

		}
	}
}

public class Solution7_BlackJack {
	public static void main(String[] args) {
		BlackJackPlay play = new BlackJackPlay();
		play.run();
	}
}
