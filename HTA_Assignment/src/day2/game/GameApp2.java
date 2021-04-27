package day2.game;

import java.util.Scanner;

public class GameApp2 {
	public static void main(String[] args) {

		Marine unit1 = new Marine();
		Firebat unit2 = new Firebat();
		Ghost unit3 = new Ghost();
		BattleCruiser unit4 = new BattleCruiser();

		unit1.setName("마린");
		unit2.setName("파이어뱃");
		unit3.setName("고스트");
		unit4.setName("배틀쿠르져");

		Scanner sc = new Scanner(System.in);
		Unit selectedUnit = null;

		
		//재정의 된 경우의 상속 활용
		while (true) {
			System.out.println("===================StarCraft===================");
			System.out.println("1.공격  2.이동  3.선택  0.종료");
			System.out.println("선택된 유닛 : " + ((selectedUnit == null) ? "선택된 유닛이 없습니다" : selectedUnit.getName()));
			System.out.println("무슨 행동을 하시겠습니까?");
			int sel = sc.nextInt();

			if (sel == 1) {
				if (selectedUnit == null) {
					System.out.println("유닛을 선택하세요");
					continue;
				}
				selectedUnit.attack();
			}

			else if (sel == 2) {
				selectedUnit.move();
			}

			else if (sel == 3) {
			
				//selectedUnit의 활용가능 메소드 범위 확인할것
				System.out.println("1.마린 2.파이어뱃 3.고스트 4.배틀쿠르저");
				int unitSel = sc.nextInt();
				if (unitSel == 1) {
					selectedUnit = unit1;
				} else if (unitSel == 2) {
					selectedUnit = unit2;
				} else if (unitSel == 3) {
					selectedUnit = unit3;
				} else if (unitSel == 4) {
					selectedUnit = unit4;
				}
			}

			else if (sel == 0) {
				System.out.println("게임 종료");
				break;
			}
		}
	}
}
