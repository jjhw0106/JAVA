package file_practice;

import java.io.FileWriter;
import java.io.BufferedReader;
import java.io.FileReader;
import java.io.File;

public class File_Read {
	public static void main(String[] args) {

		String[] ids = null;
		String[] pws = null;
		int[] moneys = null;

		String[] data = null;

		File file = new File("fileTest02.txt");
		FileReader fr = null;
		BufferedReader br = null;

		int size = 0;

		if (file.exists()) {
			try {
				fr = new FileReader(file);
				br = new BufferedReader(fr);
				while (br.readLine() != null)
					size++;
				br.close();
				data = new String[size];
				ids = new String[size];
				pws = new String[size];
				moneys = new int[size];

				fr.close();
				br.close();
			} catch (Exception e) {
				e.printStackTrace();
			}

			try {
				fr = new FileReader(file);
				br = new BufferedReader(fr);

				for (int i = 0; i < size; i++)
					data[i] = br.readLine();

				for (int i = 0; i < size; i++) {
					String[] arr = data[i].split("/");
					ids[i] = arr[0];
					pws[i] = arr[1];
					moneys[i] = Integer.parseInt(arr[2]);
				}

				fr.close();
				br.close();
			}

			catch (Exception e) {
				e.printStackTrace();
			}
		} else
			System.out.println("파일이 없습니다");

		for (int i = 0; i < size; i++)
			System.out.println(ids[i] + "/" + pws[i] + "/" + moneys[i]);
	}
}

// 메가 답
//String[] ids = null;
//String[] pws = null;
//int[] moneys = null;
//
//String fileName = "fileTest02.txt";
//
//int size = 0;
//String data = "";
//
//FileReader fr = null;
//BufferedReader br = null;
//try {
//	fr = new FileReader(fileName);
//	br = new BufferedReader(fr);
//	while (true) {
//		String line = br.readLine();
//		if (line == null) {
//			break;
//		}
//		data += line;
//		data += "\n";
//	}
//	data = data.substring(0, data.length() - 1);
//
//	String[] temp = data.split("\n");
//	size = temp.length;
//
//	ids = new String[size];
//	pws = new String[size];
//	moneys = new int[size];
//	for (int i = 0; i < size; i++) {
//		String[] info = temp[i].split("/");
//		ids[i] = info[0];
//		pws[i] = info[1];
//		moneys[i] = Integer.parseInt(info[2]);
//	}
//	for (int i = 0; i < size; i++) {
//		System.out.println(ids[i] + ":" + pws[i] + ":" + moneys[i]);
//	}
//	fr.close();
//	br.close();
//} catch (Exception e) {
//	e.printStackTrace();
//}
//
//}
//}
//​