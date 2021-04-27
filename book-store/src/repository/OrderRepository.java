package repository;

import java.io.BufferedReader;
import java.io.FileInputStream;
import java.io.FileNotFoundException;
import java.io.IOException;
import java.io.InputStreamReader;
import java.io.PrintWriter;
import java.util.ArrayList;
import java.util.List;
import java.util.Map;

import exception.OrderException;
import vo.Order;

public class OrderRepository {
	// orders.csv : ID, bookNo, amount
	private List<Order> db = new ArrayList<>();

	public OrderRepository() {
		loadData();
	}

	/**
	 * 지정된 주문정보를 저장한다.
	 * 
	 * @param order 주문정보
	 */
	public void insertOrder(Order order) {

		db.add(order);
	}

	/**
	 * 지정된 사용자의 주문내역을 반환한다.
	 * 
	 * @param userId 사용자 아이디
	 * @return 주문내역
	 */

	public List<Order> getAllOrders() {

		List<Order> orders = new ArrayList<Order>();
		for (Order order : db) {
			orders.add(order);
		}

		return orders;
	}

	private void loadData() {
		try (FileInputStream fis = new FileInputStream("src/orders.csv");
				BufferedReader br = new BufferedReader(new InputStreamReader(fis))) {

			String value = null;
			while ((value = br.readLine()) != null) {
				String[] v = value.split(",");
				db.add(new Order(v[0], Integer.parseInt(v[1]), Integer.parseInt(v[2])));
			}

		} catch (OrderException e) {
			e.printStackTrace();
		} catch (FileNotFoundException e1) {
			e1.printStackTrace();
		} catch (IOException e1) {
			e1.printStackTrace();
		}
	}

	public void saveData() {
		try (PrintWriter writer = new PrintWriter("src/orders.csv")) {
			for (Order order : db) {
				StringBuilder sb = new StringBuilder();
				sb.append(order.getUserId()).append(",")
						.append(order.getBookNo()).append(",")
						.append(order.getAmount());
				writer.println(sb);
			}
		} catch (OrderException e) {
			e.printStackTrace();
		} catch (FileNotFoundException e1) {
			e1.printStackTrace();
		}

	}
}
