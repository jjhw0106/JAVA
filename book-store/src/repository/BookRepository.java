
package repository;

import java.io.BufferedReader;
import java.io.BufferedWriter;
import java.io.FileInputStream;
import java.io.FileNotFoundException;
import java.io.FileOutputStream;
import java.io.IOException;
import java.io.InputStreamReader;
import java.io.OutputStreamWriter;
import java.io.PrintWriter;
import java.util.ArrayList;
import java.util.List;

import exception.BookException;
import vo.Book;

public class BookRepository {

	private List<Book> db = new ArrayList<>();

	public BookRepository() {
		loadData();
	}

	/**
	 * 모든 책정보를 반환한다.
	 * 
	 * @return 도서 목록
	 */
	public List<Book> getAllBooks() {
		return db;
	}

	/**
	 * 지정된 책번호의 책을 반환한다.
	 * 
	 * @param no 책번호
	 * @return 도서
	 */
	public Book getBookByNo(int no) {
		for (Book book : db) {
			if (book.getNo() == no) {
				return book;
			}
		}
		return null;
	}

	/**
	 * 지정된 책으로 책정보를 변경한다.
	 * 
	 * @param book 변경된 책정보를 포함하고 있는 책
	 */
	public void updateBook(Book book) {		// 체크
		for (Book bookToChange : db) {
			if (bookToChange.getNo() == book.getNo()) {
				bookToChange = book;
				return;
			}
		}
	}

	private void loadData() {

		try (FileInputStream fis = new FileInputStream("src/books.csv");
				BufferedReader br = new BufferedReader(new InputStreamReader(fis))) {
			String value = null;

			while ((value = br.readLine()) != null) {
				String[] v = value.split(",");
				db.add(new Book(Integer.parseInt(v[0]), v[1], v[2], v[3], v[4],
						Integer.parseInt(v[5]), Integer.parseInt(v[6]), Integer.parseInt(v[7])));
			}
		} catch (BookException e) {
			e.printStackTrace();
		} catch (FileNotFoundException e1) {
			e1.printStackTrace();
		} catch (IOException e1) {
			e1.printStackTrace();
		}

	}

	public void saveData() {
		try (PrintWriter writer = new PrintWriter("src/books.csv");) {

			for (Book book : db) {
				StringBuilder sb = new StringBuilder();
				sb.append(book.getNo());
				sb.append(",");
				sb.append(book.getCategory());
				sb.append(",");
				sb.append(book.getTitle());
				sb.append(",");
				sb.append(book.getWriter());
				sb.append(",");
				sb.append(book.getPublisher());
				sb.append(",");
				sb.append(book.getPrice());
				sb.append(",");
				sb.append(book.getDiscountPrice());
				sb.append(",");
				sb.append(book.getStock());

				writer.println(sb);
			}

		} catch (BookException e) {
			e.printStackTrace();
		} catch (FileNotFoundException e) {
			e.printStackTrace();
		}

	}
}
