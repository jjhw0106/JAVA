package shopping;

import java.io.File;
import java.io.FileReader;
import java.io.FileWriter;
import java.io.BufferedReader;

class FileManager {
	static File itemFile = new File("제품 정보.txt");
	static File categoryFile = new File("카테고리정보.txt");
	static File userFile = new File("유저정보.txt");

	// 카테고리
	static void cateSave() {
		FileWriter fw = null;
		String data = String.valueOf(ItemManager.ctList.size());
		data += "\n";
		try {
			fw = new FileWriter(categoryFile);

			for (int i = 0; i < ItemManager.ctList.size(); i++) {
				data += ItemManager.ctList.get(i).getCateName();
				data += "/";
				data += ItemManager.ctList.get(i).getpCount();
				if (i < ItemManager.ctList.size() - 1) {
					data += "\n";
				}
			}
			fw.write(data);
			fw.close();

		} catch (Exception e) {
			e.printStackTrace();
		}
	}

	static void cateLoad() {
		FileReader fr = null;
		BufferedReader br = null;
		try {
			fr = new FileReader(categoryFile);
			br = new BufferedReader(fr);
			int size = Integer.parseInt(br.readLine());
			for (int i = 0; i < size; i++) {
				String[] arr = br.readLine().split("/");
				Category temp = new Category(arr[0], Integer.parseInt(arr[1]));
				ItemManager.ctList.add(temp);
			}
			fr.close();
			br.close();
		} catch (Exception e) {
			e.printStackTrace();
		}
	}

	// 아이템
	static void itemSave() {
		FileWriter fw = null;
		String data = String.valueOf(ItemManager.itemList.size());
		data += "\n";
		try {
			fw = new FileWriter(itemFile);

			for (int i = 0; i < ItemManager.itemList.size(); i++) {
				data += ItemManager.itemList.get(i).getCategory();
				data += "/";
				data += ItemManager.itemList.get(i).getName();
				data += "/";
				data += ItemManager.itemList.get(i).getAmount();
				if (i < ItemManager.itemList.size() - 1) {
					data += "\n";
				}
			}
			fw.write(data);
			fw.close();

		} catch (Exception e) {
			e.printStackTrace();
		}
	}

	static void itemLoad() {
		FileReader fr = null;
		BufferedReader br = null;
		try {
			fr = new FileReader(itemFile);
			br = new BufferedReader(fr);
			int size = Integer.parseInt(br.readLine());
			for (int i = 0; i < size; i++) {
				String[] arr = br.readLine().split("/");
				Item temp = new Item(arr[0], arr[1], Integer.parseInt(arr[3]));
				ItemManager.itemList.add(temp);
			}
			fr.close();
			br.close();
		} catch (Exception e) {
			e.printStackTrace();
		}
	}

	// 유저
	static void userSave() {
		FileWriter fw = null;
		String data = String.valueOf(UserManager.userList.size());
		data += "\n";
		try {
			fw = new FileWriter(userFile);

			for (int i = 0; i < UserManager.userList.size(); i++) {
				data += UserManager.userList.get(i).getId();
				data += "/";
				data += UserManager.userList.get(i).getPw();
				data += "/";
				data += UserManager.userList.get(i).getName();
				if (i < UserManager.userList.size() - 1) {
					data += "\n";
				}
			}
			fw.write(data);
			fw.close();

		} catch (Exception e) {
			e.printStackTrace();
		}
	}

	static void userLoad() {
		FileReader fr = null;
		BufferedReader br = null;
		try {
			fr = new FileReader(userFile);
			br = new BufferedReader(fr);
			int size = Integer.parseInt(br.readLine());
			for (int i = 0; i < size; i++) {
				String[] arr = br.readLine().split("/");
				User temp = new User(arr[0], arr[1], arr[2]);
				UserManager.userList.add(temp);
			}
			fr.close();
			br.close();
		} catch (Exception e) {
			e.printStackTrace();
		}
	}

}
