package service;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

import exception.BookException;
import exception.UserException;
import repository.BookRepository;
import repository.OrderRepository;
import repository.UserRepository;
import vo.Book;
import vo.Order;
import vo.User;

public class BookStoreService {

	private BookRepository bookRepository = new BookRepository();
	private UserRepository userRepository = new UserRepository();
	private OrderRepository orderRepository = new OrderRepository();
	private User loginedUser = null;

	/**
	 * 모든 책정보를 반환한다.
	 * 
	 * @return 도서 목록
	 */
	public List<Book> getAllBookList() {
		return bookRepository.getAllBooks();
	}

	/**
	 * 지정된 카테고리에 해당하는 책 정보들을 반환한다.
	 * 
	 * @param category 조회할 도서 카테고리
	 * @return 도서 목록
	 */
	public List<Book> searchBooksByCategory(String category) {
		ArrayList<Book> books = new ArrayList<Book>();
		for (Book book : bookRepository.getAllBooks()) {
			if (book.getCategory().contains(category))
				books.add(book);
		}
		if (books.isEmpty())
			throw new BookException("존재하지 않는 카테고리입니다.");
		return books;
	}

	/**
	 * 지정된 책 제목을 포함하고 잇는 책 정보들을 반환한다.
	 * 
	 * @param title 조회할 도서 제목
	 * @return 도서 목록
	 */
	public List<Book> searchBooksByTitle(String title) {
		ArrayList<Book> books = new ArrayList<Book>();
		for (Book book : bookRepository.getAllBooks()) {
			if (book.getTitle().contains(title))
				books.add(book);
		}
		if (books.isEmpty())	// books==null 쓰면 deadCode오류 why?
			throw new BookException("제목이 일치하는 책이 없습니다.");
		return books;
	}

	/**
	 * 지정된 가격범위에 속하는 책 정보들을 반환한다.
	 * 
	 * @param minPrice 최소 가격
	 * @param maxPrice 최대 가격
	 * @return 도서 목록
	 */
	public List<Book> searchBooksByPrice(int minPrice, int maxPrice) {
		ArrayList<Book> books = new ArrayList<Book>();
		for (Book book : bookRepository.getAllBooks()) {
			if (book.getPrice() >= minPrice && book.getPrice() <= maxPrice) {
				books.add(book);
			}
		}
		return books;
	}

	/**
	 * 지정된 책번호에 해당하는 책정보를 반환한다.
	 * 
	 * @param no 조회할 책 번호
	 * @return 도서
	 */
	public Book findBook(int no) {
		if (bookRepository.getBookByNo(no) == null) {
			throw new BookException("책 번호가 잘못되었습니다.");
		}

		return bookRepository.getBookByNo(no);
	}

	/**
	 * 지정된 책번호의 재고를 변경한다.
	 * 
	 * @param no    책번호
	 * @param stock 변경된 재고량
	 */
	public void updateBookStock(int no, int stock) {	// 체크
		Book book = bookRepository.getBookByNo(no);
		book.setStock(stock);
		bookRepository.updateBook(book);
	}

	/**
	 * 지정된 사용자정보를 등록한다.
	 * 
	 * @param user 새 사용자
	 */
	public void addNewUser(User user) {
		if (userRepository.getUserById(user.getId()) != null) {
			throw new UserException("중복된 유저ID입니다.");
		}
		userRepository.insertUser(user);
	}

	/**
	 * 지정된 아이디와 비밀번호로 사용자정보를 인증한다.
	 * 
	 * @param id       아이디
	 * @param password 비밀번호
	 */
	public void login(String id, String password) {
		User user = null;
		if ((user = userRepository.getUserById(id)) == null
				|| !userRepository.getUserById(id).getPassword().equals(password)) {
			throw new UserException("아이디 혹은 비밀번호를 확인하세요");
		}
		System.out.println("예외 분기 check");
		loginedUser = user;
	}

	/**
	 * 로그인된 사용자 정보를 삭제한다.
	 */
	public void logout() {
		loginedUser = null;
	}

	/**
	 * 로그인여부를 반환한다.
	 * 
	 * @return 로그인된 사용자정보가 존재하면 true를 반환한다.
	 */
	public boolean isLogined() {
		return loginedUser == null ? false : true;
	}

	/**
	 * 치정된 책번호의 책을 수량만큼 주문한다.
	 * 
	 * @param bookNo 책번호
	 * @param amount 주문수량
	 */
	public void orderBook(int bookNo, int amount) {
		Order order = new Order();
		Book book = bookRepository.getBookByNo(bookNo);
		if (book == null) {
			throw new BookException("찾으시는 책의 번호가 없습니다");
		}
		if (book.getStock() < amount) {
			throw new BookException("도서 재고가 부족합니다");
		}
		if (loginedUser == null) {
			throw new BookException("로그인 하세요");
		}
		order.setUserId(loginedUser.getId());
		order.setBookNo(bookNo);
		order.setAmount(amount);
		book.setStock(book.getStock() - amount);
		bookRepository.updateBook(book);

		orderRepository.insertOrder(order);
	}

	/**
	 * 로그인한 사용자의 주문정보를 반환한다.
	 * 
	 * @return 주문 목록
	 */
	public List<Map<String, Object>> getMyOrderList() {
		List<Map<String, Object>> getOrderList = new ArrayList<Map<String, Object>>();
		if (loginedUser == null) {
			throw new UserException("로그인이 필요합니다");
		}
		for (Order order : orderRepository.getAllOrders()) {
			if (order.getUserId().equals(loginedUser.getId())) {
				Map<String, Object> details = new HashMap<String, Object>();
				Book book = bookRepository.getBookByNo(order.getBookNo());

				details.put("책번호", book.getNo());
				details.put("도서명", book.getTitle());
				details.put("구매수량", order.getAmount());
				details.put("총 구매가격", book.getPrice() * order.getAmount());
				details.put("적립 포인트", book.getPrice() * order.getAmount() * 0.05);
				getOrderList.add(details);
			}
		}
		return getOrderList;
	}
//	변동성이 큰 데이터를 저장하는 객체
//	ValueObject를 대체하는 객체
//	2개 이상의 ValueObject를 조합해서 저장할 때 유용한 객체
	
//	객체와 객체를 연결한다는 개념으로 이해하지 말것.
	
	/**
	 * 로그인한 사용자의 상세정보를 반환한다.
	 * 
	 * @return
	 */
	public User getMyInfo() {
		return loginedUser;
	}

	/**
	 * 모든 정보를 저장한다.
	 */
	public void restore() {
		userRepository.saveData();
		bookRepository.saveData();
		orderRepository.saveData();
	}
}
