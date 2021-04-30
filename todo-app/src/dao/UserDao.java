package dao;

import java.io.BufferedReader;
import java.io.FileNotFoundException;
import java.io.FileReader;
import java.io.FileWriter;
import java.io.IOException;
import java.io.PrintWriter;
import java.util.ArrayList;
import java.util.Date;
import java.util.List;

import exception.TodoException;
import utils.StringUtils;
import vo.User;

public class UserDao {
	public UserDao() {
		loadData();
	}

	private List<User> db = new ArrayList<User>();

	/**
	 * 새 User을 db에 추가한다.
	 * 
	 * @param user 새 User
	 */
	public void insertUser(User user) {
		db.add(user);
	}

	/**
	 * 모든 User 정보를 반환한다.
	 * 
	 * @return User 리스트
	 */
	public List<User> getUsers() {
		return db;
	}

	/**
	 * 지정한 사용자 아이디의 User 정보를 반환한다.
	 * 
	 * @param id userId
	 * @return User 정보
	 */
	public User getUserById(String id) {
		for (User user : db) {
			if (user.getId().equals(id)) {
				return user;
			}
		}
		return null;
	}

	/**
	 * users.csv에 기록된 사용자정보를 읽어서 db에 저장한다.
	 */
	public void loadData() {
		try (FileReader fr = new FileReader("users.csv");
				BufferedReader br = new BufferedReader(fr)) {
			String value = null;
			while ((value = br.readLine()) != null) {
				String[] str = value.split(",");
				String id = str[0];
				String password = str[1];
				String username = str[2];
				boolean isdisabled = StringUtils.stringToBoolean(str[3]);
				Date createDate = StringUtils.stringToDate(str[4]);
				Date deletedDate = StringUtils.stringToDate(str[5]);

				db.add(new User(id, password, username, isdisabled, createDate, deletedDate));
			}

		} catch (FileNotFoundException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		} catch (IOException e1) {
			// TODO Auto-generated catch block
			e1.printStackTrace();
		}
	}

	/**
	 * db에 저장된 사용자 정보를 users.csv 파일에 저장한다.
	 */
	public void saveData() {
		try (PrintWriter pw = new PrintWriter("users.csv")) {
			for (User user : db) {
				StringBuilder sb = new StringBuilder();
				sb.append(user.getId()).append(",");
				sb.append(user.getPassword()).append(",");
				sb.append(user.getUsername()).append(",");
				sb.append(String.valueOf(user.isDisabled())).append(",");
				sb.append(StringUtils.dateToString(user.getCreatedDate())).append(",");
				sb.append(StringUtils.dateToString(user.getDeletedDate()));

				pw.println(sb);
			}
		} catch (FileNotFoundException e) {
			e.printStackTrace();
		}
	}
}
