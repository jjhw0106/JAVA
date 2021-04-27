package atm_v2;

import java.io.File;
import java.io.FileWriter;
import java.io.FileReader;
import java.io.BufferedReader;

class FileManager {
	static File file = new File("ATMv2 data.txt");

	static void save() {
		FileWriter fw = null;
		try {
			fw = new FileWriter(file);
			String data = "";
			String acc = "";
			String money;
			String id;
			String pw;
			String name;
			data = String.valueOf(UserManager.uList.size());
			data += "\n";
			for (int i = 0; i < UserManager.uList.size(); i++) {

				id = String.valueOf(UserManager.uList.get(i).getId());
				pw = String.valueOf(UserManager.uList.get(i).getPw());
				name = String.valueOf(UserManager.uList.get(i).getName());

				data += id;
				data += "/";
				data += pw;
				data += "/";
				data += name;
				data += "/";
				data += UserManager.uList.get(i).accountCnt();
				data += "/";

				for (int j = 0; j < UserManager.uList.get(i).accountCnt(); j++) {
					money = String.valueOf(UserManager.uList.get(i).accounts[j].getMoney());
					for (int k = 0; k < 9; k++) {
						acc += String.valueOf(UserManager.uList.get(i).accounts[j].accNum[k]);
					}
					data += acc;
					data += "/";
					acc = "";
					data += money;
					data += "/";
				}
				if (i != UserManager.uList.size() - 1)
					data += "\n";
			}
			fw.write(data);

			fw.close();
		} catch (

		Exception e) {
			e.printStackTrace();
		}
	}

	static void load() {
		FileReader fr;
		BufferedReader br;
		try {
			fr = new FileReader(file);
			br = new BufferedReader(fr);
			int size = Integer.parseInt(br.readLine());
			for (int i = 0; i < size; i++) {
				String data[] = br.readLine().split("/");
				User temp = new User(data[0], data[1], data[2]);
				int accCnt = Integer.parseInt(data[3]);
				for (int k = 0; k < accCnt; k++) {
					int tempAccount[] = new int[9];
					for (int n = 0; n < 9; n++) {
						tempAccount[n] = Integer.parseInt(data[2 * k + 4].substring(n, n + 1));
					}
					temp.accounts[k] = new Account();
					temp.accounts[k].accNum = tempAccount;
					temp.accounts[k].setMoney(Integer.parseInt(data[2 * k + 5]));
					AccountManager.accList.add(temp.accounts[k]);
					temp.accounts[k] = AccountManager.accList.get(AccountManager.accList.size() - 1);
				}
				UserManager.uList.add(temp);
			}
			fr.close();
			br.close();
		} catch (Exception e) {
			e.printStackTrace();
		}
	}
}