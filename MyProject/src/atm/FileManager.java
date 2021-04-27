package atm;

import java.io.File;
import java.io.FileReader;
import java.io.FileWriter;
import java.io.BufferedReader;

class FileManager {

	File file = new File("ATM data.txt");

	void save() {
		FileWriter fw;
		try {
			String data = "";
			fw = new FileWriter(file);
			data = String.valueOf(UserManager.uList.size());
			data += "\n";
			for (int i = 0; i < UserManager.uList.size(); i++) {
				data += UserManager.uList.get(i).getId();
				data += "/";
				data += UserManager.uList.get(i).getPw();
				data += "/";
				data += UserManager.uList.get(i).getName();
				for (int j = 0; j < UserManager.uList.get(i).accList.size(); j++) {
					data += "/";
					data += UserManager.uList.get(i).accList.get(j).showAccNum();
					data += "/";
					data += UserManager.uList.get(i).accList.get(j).getMoney();
				}
				if (i != UserManager.uList.size() - 1)
					data += "\n";
			}
			fw.write(data);
			fw.close();
		} catch (Exception e) {
			e.printStackTrace();
		}
	}

	void load() {
		FileReader fr;
		BufferedReader br;
		String data = "";
		try {
			fr = new FileReader(file);
			br = new BufferedReader(fr);
			int size = Integer.parseInt(br.readLine());

			for (int i = 0; i < size; i++) {
				User temp = new User();
				data = br.readLine();
				String arr[] = data.split("/");
				temp.setId(arr[0]);
				temp.setPw(arr[1]);
				temp.setName(arr[2]);
				if (arr.length >= 4) {
					for (int j = 0; j < (arr.length - 3) / 2; j++) {
						Account tempAcc = new Account();
						tempAcc.setAccNum(arr[2*j + 3]);
						tempAcc.setMoney(Integer.parseInt(arr[2*j+4]));
						temp.accList.add(tempAcc);
					}
				}
				UserManager.uList.add(temp);
			}
			fr.close();
			br.close();
		} catch (Exception e) {
			e.printStackTrace();// 항상 써줄것, 안썼다가 오류난걸 모르고 고생함
		}
	}
}
