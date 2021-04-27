package file_practice;

import java.io.FileWriter;
import java.io.BufferedReader;
import java.io.FileReader;
import java.io.File;
import java.util.Scanner;

public class File_In_Out {
	public static void main(String[] args) {

		String[] names = { "momk", "megait", "github" };
		String[] pws = { "1111", "2222", "3333" };

		int[] moneys = { 20000, 30000, 40000 };
		int size = names.length;

		File file = new File("fileTest02.txt");
		String[] data = new String[size];

		for (int i = 0; i < size; i++) {
			data[i] = names[i] + "/" + pws[i] + "/" + moneys[i];
			if (i < size - 1)
				data[i] += "\n";
		}

		try {
			FileWriter fw = new FileWriter(file);
			for (int i = 0; i < size; i++)
				fw.write(data[i]);
			fw.close();

		} catch (Exception e) {
			e.printStackTrace();
		}

	}
}
