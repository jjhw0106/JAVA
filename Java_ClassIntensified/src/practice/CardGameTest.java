package practice;

// 1) 카드모양 : 다이아 , 하트 , 스페이드 , 클로버
// 2) 숫자      :  1~10
// 3) 총 40장이 있다. 
// 4) 2장씩 나눠갖은 다음 , 각 카드의 숫자의 합이 큰쪽이 이긴다. (직접만들기)
import java.util.Random;
import java.util.Scanner;

//♥◆♠♣
class CardDeck {
	int cardCnt = 40;
	Random ran = new Random();
	String card[][] = new String[cardCnt][2];
	int cardEndIdx = cardCnt - 1;

	void cardInit() {
		for (int i = 0; i < cardCnt; i++) {
			if (i < 10) {
				card[i][0] = "♥";
				card[i][1] = String.valueOf(i % 10 + 1);
			} else if (i < 20) {
				card[i][0] = "◆";
				card[i][1] = String.valueOf(i % 10 + 1);
			} else if (i < 30) {
				card[i][0] = "♠";
				card[i][1] = String.valueOf(i % 10 + 1);
			} else if (i < 40) {
				card[i][0] = "♣";
				card[i][1] = String.valueOf(i % 10 + 1);
			}
		}

	}

	void shuffle() {
		for (int i = 0; i < 500; i++) {
			int rNum = ran.nextInt(40);
			String temp1 = card[0][0];
			String temp2 = card[0][1];
			card[0][0] = card[rNum][0];
			card[0][1] = card[rNum][1];
			card[rNum][0] = temp1;
			card[rNum][1] = temp2;
		}
	}

	String pickCard() {
		String pick = card[cardEndIdx][0];
		pick += card[cardEndIdx][1];

		return pick;
	}
}

class Player {
	int num;// 플레이어 번호
	int getCard = 2;// 카드 몇 장인지
	int sum = 0;
	int life = 1;
	String[][] myCard = new String[10][2];
}

class Gamble {
	Scanner sc = new Scanner(System.in);

	String getCard(String cardShape, String cardNum) {

		return cardNum;
	}

	void playerSet() {

	}

	void show() {
	}

	void hit() {

	}

	void run() {
		CardDeck c = new CardDeck();

		System.out.print("참여 인원: ");
		int gamerNum = sc.nextInt();
		Player p[] = new Player[gamerNum];
		for (int i = 0; i < gamerNum; i++) {
			p[i] = new Player();
		}
		c.cardInit();
		System.out.println("카드 섞는 중..");
		try {
			c.shuffle();
			Thread.sleep(100);
		} catch (Exception e) {
		}
		System.out.println("카드 분배");

		int cardEnd = c.cardCnt - 1;
		for (int k = 0; k < 2; k++) {
			for (int i = 0; i < gamerNum; i++) {
				p[i].myCard[k][0] = c.card[cardEnd][0];
				p[i].myCard[k][1] = c.card[cardEnd][1];
				p[i].num = i + 1;
				p[i].sum += Integer.parseInt(p[i].myCard[k][1]);
				cardEnd--;
			}
		}

		int turn = 0;
		while (true) {
			System.out.println("==========Black Jack==========");
			for (int i = 0; i < gamerNum; i++) {
				System.out.print(p[i].num + ": ");
				for (int j = 0; j < p[i].getCard; j++) {
					System.out.print(p[i].myCard[j][0] + p[i].myCard[j][1] + " ");
				}
				System.out.print("합계:" + p[i].sum);
				if (p[i].life == -1) {
					System.out.print("(Dead)");
				}
				System.out.println();
			}
			System.out.println("==============================");

			if (turn >= gamerNum) {
				break;
			}
			System.out.println((turn + 1) + "번, Hit Or Stay");
			int sel = sc.nextInt();
			if (sel == 1) {
				System.out.println((turn + 1) + "번 hit");
				p[turn].myCard[p[turn].getCard][0] = c.card[cardEnd][0];
				p[turn].myCard[p[turn].getCard][1] = c.card[cardEnd][1];
				p[turn].getCard++;
				cardEnd--;
				p[turn].sum += Integer.parseInt(p[turn].myCard[p[turn].getCard - 1][1]);
				if (p[turn].sum > 21) {
					System.out.println("You died");
					p[turn].life = -1;
					turn++;
				}
				continue;
			} else if (sel == 2) {
				System.out.println((turn + 1) + "번 stay");
				turn++;
			}
		}
		int winnerIdx = -1;
		int max = 0;
		for (int i = 0; i < gamerNum; i++) {
			if (p[i].life == 1) {
				max = p[i].sum;
				winnerIdx = i;
				break;
			}
		}

		// 목숨 확인용/////
		for (int i = 0; i < gamerNum; i++) {
			System.out.println(p[i].life);
		}
		//

		for (int i = 0; i < gamerNum; i++) {
			if (p[i].life == 1) {
				if (max < p[i].sum && p[i].life == 1) {
					max = p[i].sum;
					winnerIdx = i;
				}
			}
		}
		if (winnerIdx == -1) {
			System.out.println("전원 사망");
		} else {
			System.out.println("우승자 " + p[winnerIdx].num + "!!!");
		}
	}
}

public class CardGameTest {
	public static void main(String[] args) {

		Gamble play = new Gamble();
		play.run();
	}

}