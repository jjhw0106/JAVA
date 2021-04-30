package dao;

import java.util.ArrayList;
import java.util.List;

import vo.Todo;

public class TodoDao {

	private List<Todo> db = new ArrayList<Todo>();
	
	/**
	 * 새 Todo을 db에 추가한다.
	 * @param todo 새 Todo
	 */
	public void insertTodo(Todo todo) {
		
	}
	
	/**
	 * 모든 Todo 정보를 반환한다.
	 * @return Todo 리스트
	 */
	public List<Todo> getTodos() {
		return db;
	}
	
	/**
	 * 지정한 Todo 번호의 Todo 정보를 반환한다.
	 * @param no 일정번호
	 * @return Todo정보
	 */
	public Todo getTodoByNo(int no) {
		return null;
	}
	
	/**
	 * todos.csv에 기록된 Todo정보를 읽어서 db에 저장한다.
	 */
	public void loadData() {
		
	}
	
	/**
	 * db에 저장된 Todo 정보를 totos.csv 파일에 저장한다.
	 */
	public void saveData() {
		
	}
}
