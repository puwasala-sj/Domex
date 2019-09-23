package Service;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;
import java.util.ArrayList;

import Model.CardPayment;
import Model.CashPayment;
import Model.ChequePayment;
import Util.myDB;

public class IOrderPaymentServiceImplement implements IOrderPaymentService {
	
	private static Connection conn;

	public IOrderPaymentServiceImplement() {
		conn = myDB.getDBconection();
	}

	@Override
	public boolean addNewOrderPayment(CashPayment c1) throws SQLException {
		String sql = "Insert into cashpayment values(?,?,?,?)";
		PreparedStatement ps = conn.prepareStatement(sql);
		
		ps.setObject(1, c1.getCashPID());
		ps.setObject(2, c1.getAmount());
		ps.setObject(3, c1.getDeliveryDate());
		ps.setObject(4, c1.getDeliveryAddress());
		int res = ps.executeUpdate();
		
		return res > 0;
	}

	@Override
	public boolean addNewOrderPayment(ChequePayment ch1) throws SQLException {
		String sql = "Insert into chequepayment values(?,?,?,?)";
		PreparedStatement ps = conn.prepareStatement(sql);
		
		ps.setObject(1, ch1.getChequePID());
		ps.setObject(2, ch1.getAmount());
		ps.setObject(3, ch1.getChequeNumber());
		ps.setObject(4, ch1.getBank());

	
		int res = ps.executeUpdate();
		
		return res > 0;
	}

	@Override
	public boolean addNewOrderPayment(CardPayment ca1) throws SQLException {
		String sql = "Insert into cardpayment values(?,?,?,?,?,?)";
		PreparedStatement ps = conn.prepareStatement(sql);
		
		ps.setObject(1, ca1.getCardPID());
		ps.setObject(2, ca1.getAmount());
		ps.setObject(3, ca1.getCardType());
		ps.setObject(4, ca1.getCardNumber());
		ps.setObject(5, ca1.getExpiryDate());
		ps.setObject(6, ca1.getCcv());
		
		int res = ps.executeUpdate();
		
		return res > 0;
	}

	@Override
	public ArrayList<CashPayment> getCashPayments() throws SQLException {
		String sql = "select*from cashpayment";
		Statement stm = conn.createStatement();
		ResultSet rst = stm.executeQuery(sql);
		
		ArrayList<CashPayment> c1List = new ArrayList<CashPayment>();
		
		while(rst.next()) {
			
			CashPayment c1= new CashPayment();
			
			c1.setCashPID(rst.getInt("cashPID"));
			c1.setAmount(rst.getString("amount"));
			c1.setDeliveryDate(rst.getString("deliveryDate"));
			c1.setDeliveryAddress(rst.getString("deliveryAddress"));

			c1List.add(c1);
			
		}
		
		return c1List;
	}

	@Override
	public ArrayList<ChequePayment> getChequePayments() throws SQLException {
		String sql = "select*from chequepayment";
		Statement stm = conn.createStatement();
		ResultSet rst = stm.executeQuery(sql);
		
		ArrayList<ChequePayment> ch1List = new ArrayList<ChequePayment>();
		
		while(rst.next()) {
			
			ChequePayment ch1= new ChequePayment();
			
			ch1.setChequePID(rst.getInt("chequePID"));
			ch1.setAmount(rst.getString("amount"));
			ch1.setChequeNumber(rst.getString("chequeNumber"));
			ch1.setBank(rst.getString("bank"));
			
			ch1List.add(ch1);
			
		}
		
		return ch1List;
	}

	@Override
	public ArrayList<CardPayment> getCardPayments() throws SQLException {
		String sql = "select*from cardpayment";
		Statement stm = conn.createStatement();
		ResultSet rst = stm.executeQuery(sql);
		
		ArrayList<CardPayment> ca1List = new ArrayList<CardPayment>();
		
		while(rst.next()) {
			
			CardPayment ca1= new CardPayment();
			
			ca1.setCardPID(rst.getInt("cardPID"));
			ca1.setAmount(rst.getString("amount"));
			ca1.setCardType(rst.getString("cardType"));
			ca1.setCardNumber(rst.getString("cardNumber"));
			ca1.setExpiryDate(rst.getString("expiryDate"));
			ca1.setCcv(rst.getString("ccv"));
			
			ca1List.add(ca1);
			
		}
		
		return ca1List;
	}

	@Override
	public boolean deleteCashPayment(int cashPID) throws SQLException {
		String sql = "delete from cashpayment where cashPID = '"+cashPID+"'";
		Statement stm = conn.createStatement();
		
		return stm.executeUpdate(sql) > 0;
	}

	@Override
	public boolean deleteChequePayment(int chequePID) throws SQLException {
		String sql = "delete from chequepayment where chequePID = '"+chequePID+"'";
		Statement stm = conn.createStatement();
		
		return stm.executeUpdate(sql) > 0;
	}

	@Override
	public boolean deleteCardPayment(int cardPID) throws SQLException {
		String sql = "delete from cardpayment where cardPID = '"+cardPID+"'";
		Statement stm = conn.createStatement();
		
		return stm.executeUpdate(sql) > 0;
	}

}
