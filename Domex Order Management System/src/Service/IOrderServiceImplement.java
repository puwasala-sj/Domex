package Service;

import java.sql.Connection;

import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;
import java.util.ArrayList;


import Model.Order;
import Util.myDB;

public class IOrderServiceImplement implements OrderService {
	
	private static Connection conn;

	public IOrderServiceImplement() {
		conn = myDB.getDBconection();
	}

	@Override
	public boolean addNewOrder(Order order) throws SQLException {
		String sql = "insert into `order`(`orderID` , `customer_Name` , `packages` , `type` , `weight` , `receiver` , `address` , `district` , `town` , `postcode` , `charge` ) values(?,?,?,?,?,?,?,?,?,?,?);";
		PreparedStatement ps = conn.prepareStatement(sql);
		
		ps.setObject(1,order.getOrderID());
		ps.setObject(2, order.getCustomer_Name());
		ps.setObject(3, order.getPackages());
		ps.setObject(4, order.getType());
		ps.setObject(5,order.getWeight());
		ps.setObject(6, order.getReceiver());
		ps.setObject(7,order.getAddress() );
		ps.setObject(8, order.getDistrict());
		ps.setObject(9, order.getTown());
		ps.setObject(10, order.getPostCode());
		ps.setObject(11, order.getCharge());
		
		int res = ps.executeUpdate();
		
		return res > 0;
	}

	@Override
	public ArrayList<Order> getOrders() throws SQLException {
		String sql = "select*from `order`;";
		Statement stm = conn.createStatement();
		ResultSet result = stm.executeQuery(sql);
		
		ArrayList<Order> oList = new ArrayList<Order>();
		
		while(result.next()) {
			
			Order o= new Order();
			
			o.setOrderID(result.getInt("orderID"));	System.out.println(o.getOrderID());
			o.setCustomer_Name(result.getString("customer_Name"));System.out.println(o.getCustomer_Name());
			o.setPackages(result.getString("packages"));System.out.println(o.getPackages());
			o.setType(result.getString("type"));System.out.println(o.getType());
			o.setWeight(result.getFloat("weight"));System.out.println(o.getWeight());
			o.setReceiver(result.getString("receiver"));System.out.println(o.getReceiver());
			o.setAddress(result.getString("address"));System.out.println(o.getDistrict());
			o.setDistrict(result.getString("district"));System.out.println(o.getAddress());
			o.setTown(result.getString("town"));System.out.println(o.getTown());
			o.setPostCode(result.getInt("postCode"));System.out.println(o.getPostCode());
			o.setCharge(result.getFloat("charge"));System.out.println(o.getCharge());
			
			oList.add(o);
			
		}
		
		return oList;
	}

	@Override
	public boolean deleteOrder(int orderID) throws SQLException {
		String sql = "delete from `order` where orderID = '"+orderID+"'";
		Statement stm = conn.createStatement();
		
		return stm.executeUpdate(sql) > 0;
	}
	
	@Override
	public ArrayList<Order> getOrderInfo(int OrderID) throws SQLException {
		// TODO Auto-generated method stub
		String sql = "select * from `order` where chequePID  = '"+OrderID+"'";
		Statement stm = conn.createStatement();
		ResultSet result = stm.executeQuery(sql);
		
		ArrayList<Order> oList = new ArrayList<Order>();
		
		while(result.next()) {
			
			Order o= new Order();
			
			o.setOrderID(result.getInt("orderID"));	
			o.setCustomer_Name(result.getString("customer_Name"));
			o.setPackages(result.getString("packages"));
			o.setType(result.getString("type"));
			o.setWeight(result.getFloat("weight"));
			o.setReceiver(result.getString("receiver"));
			o.setAddress(result.getString("address"));
			o.setDistrict(result.getString("district"));
			o.setTown(result.getString("town"));
			o.setPostCode(result.getInt("postCode"));
			o.setCharge(result.getFloat("charge"));
			
			oList.add(o);
			
		}
		
		return oList;
	}
	
	@Override
	public boolean updateCardInfo(Order order) throws SQLException {
		// TODO Auto-generated method stub

		String sql = "UPDATE `order` SET `orderID` =? , `customer_Name`=? , `packages`=? , `type`=? , `weight`=? , `receiver`=? , `address`=? , `district`=? , `town`=? , `postcode`=? , `charge`=? where `orderID' = " + order.getOrderID();
		PreparedStatement ps = conn.prepareStatement(sql);
		
		ps.setObject(1,order.getOrderID());
		ps.setObject(2, order.getCustomer_Name());
		ps.setObject(3, order.getPackages());
		ps.setObject(4, order.getType());
		ps.setObject(5,order.getWeight());
		ps.setObject(6, order.getReceiver());
		ps.setObject(7,order.getAddress() );
		ps.setObject(8, order.getDistrict());
		ps.setObject(9, order.getTown());
		ps.setObject(10, order.getPostCode());
		ps.setObject(11, order.getCharge());
		
		int res = ps.executeUpdate();
		
		return res > 0;
	}
}
