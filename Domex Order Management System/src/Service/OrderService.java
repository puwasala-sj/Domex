package Service;

import java.sql.SQLException;
import java.util.ArrayList;

import Model.CardPayment;
import Model.Order;

public interface OrderService {
	
	boolean addNewOrder (Order o) throws SQLException;

	public ArrayList<Order> getOrders() throws SQLException;

	boolean deleteOrder(int orderID) throws SQLException;

	ArrayList<Order> getOrderInfo(int orderID) throws SQLException;

	boolean updateOrderInfo(Order o) throws SQLException;
}
