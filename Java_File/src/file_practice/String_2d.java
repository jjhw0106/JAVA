package file_practice;

public class String_2d {
	public static void main(String[] args) {

		// 문제) 이름은 name배열에 성적은 score배열에 각각 저장 및 출력

		String str = "김철수/87,이만수/42,이영희/95";

		String[] name = new String[3];
		int[] score = new int[3];

		String[] arr = str.split(",");
		String[] arr2 = new String[2];

		for (int i = 0; i < arr.length; i++) {
			arr2 = arr[i].split("/");
			name[i] = arr2[0];
			score[i] = Integer.parseInt(arr2[1]);

		}

		for (int i = 0; i < arr.length; i++) {
			System.out.println(name[i] + " " + score[i]);
		}

	}
}
