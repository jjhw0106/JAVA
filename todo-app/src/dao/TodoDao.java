package dao;

import java.io.BufferedReader;
import java.io.FileNotFoundException;
import java.io.FileReader;
import java.io.IOException;
import java.io.PrintWriter;
import java.util.ArrayList;
import java.util.List;

import utils.StringUtils;
import vo.Todo;

public class TodoDao {

	private List<Todo> db = new ArrayList<Todo>();

	/**
	 * 새 Todo을 db에 추가한다.
	 * 
	 * @param todo 새 Todo
	 */
	public void insertTodo(Todo todo) {
		db.add(todo);
	}

	/**
	 * 모든 Todo 정보를 반환한다.
	 * 
	 * @return Todo 리스트
	 */
	public List<Todo> getTodos() {
		return db;
	}

	/**
	 * 지정한 Todo 번호의 Todo 정보를 반환한다.
	 * 
	 * @param no 일정번호
	 * @return Todo정보
	 */
	public Todo getTodoByNo(int no) {
		for (Todo todo : db) {
			if (todo.getNo() == no) {
				return todo;
			}
		}
		return null;
	}

	/**
	 * todos.csv에 기록된 Todo정보를 읽어서 db에 저장한다.
	 */
	public void loadData() {
		try (FileReader fr = new FileReader("todos.csv");
				BufferedReader br = new BufferedReader(fr)) {
			String value = null;
			while ((value = br.readLine()) != null) {
				String str[] = value.split(",");
				Todo todo = new Todo();
				todo.setNo(Integer.parseInt(str[0]));
				todo.setTitle(str[1]);
				todo.setWriter(new UserDao().getUserById(str[2]));
				todo.setDay(utils.StringUtils.stringToDate(str[3]));
				todo.setStatus(str[4]);
				todo.setText(str[5]);
				todo.setCreatedDate(utils.StringUtils.stringToDate(str[6]));
				todo.setCompletedDate(utils.StringUtils.stringToDate(str[7]));
				todo.setDeletedDate(utils.StringUtils.stringToDate(str[8]));
				db.add(todo);
			}

		} catch (FileNotFoundException e) {
			e.printStackTrace();
		} catch (IOException e1) {
			e1.printStackTrace();
		}
	}

	/**
	 * db에 저장된 Todo 정보를 totos.csv 파일에 저장한다.
	 */
	public void saveData() {
		try (PrintWriter pw = new PrintWriter("todos.csv");) {
			for (Todo todo : db) {
				StringBuilder sb = new StringBuilder();
				sb.append(todo.getNo()).append(",");
				sb.append(todo.getTitle()).append(",");
				sb.append(todo.getWriter().getId()).append(",");
				sb.append(StringUtils.dateToString(todo.getDay())).append(",");
				sb.append(todo.getStatus()).append(",");
				sb.append(todo.getText()).append(",");
				sb.append(StringUtils.dateToString(todo.getCreatedDate())).append(",");
				sb.append(StringUtils.dateToString(todo.getCompletedDate())).append(",");
				sb.append(StringUtils.dateToString(todo.getDeletedDate()));

				pw.println(sb);
			}
		} catch (FileNotFoundException e) {
			e.printStackTrace();
		}

	}
}
