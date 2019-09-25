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

	@Override
	public boolean updateCashInfo(CashPayment c1) throws SQLException {
		// TODO Auto-generated method stub
		String sql = "UPDATE cashpayment SET cashPID = ?, amount = ?, deliveryDate = ?, deliveryAddress = ? where cashPID = " + c1.getCashPID();
		PreparedStatement stm = conn.prepareStatement(sql);
		stm.setObject(1,c1.getCashPID());
		stm.setObject(2,c1.getAmount());
		stm.setObject(3,c1.getDeliveryDate());
		stm.setObject(4,c1.getDeliveryAddress());
		
		int res = stm.executeUpdate();
		
		return res>0;
	}

	@Override
	public boolean updateChequeInfo(ChequePayment ch1) throws SQLException {
		// TODO Auto-generated method stub
		String sql = "UPDATE chequepayment SET chequePID = ?, amount = ?, chequeNumber = ?, bank = ? where chequePID = " + ch1.getChequePID();
		PreparedStatement stm = conn.prepareStatement(sql);
		stm.setObject(1,ch1.getChequePID());
		stm.setObject(2,ch1.getAmount());
		stm.setObject(3,ch1.getChequeNumber());
		stm.setObject(4,ch1.getBank());
		
		int res = stm.executeUpdate();
		
		return res>0;
	}

	@Override
	public boolean updateCardInfo(CardPayment ca1) throws SQLException {
		// TODO Auto-generated method stub
		String sql = "UPDATE cardpayment SET cardPID = ?,amount = ?, cardType = ?, cardNumber = ?, expiryDate = ?, ccv = ?, where cardPID = " + ca1.getCardPID();
		PreparedStatement stm = conn.prepareStatement(sql);
		stm.setObject(1,ca1.getCardPID());
		stm.setObject(2,ca1.getAmount());
		stm.setObject(3,ca1.getCardType());
		stm.setObject(4,ca1.getCardNumber());
		stm.setObject(5,ca1.getExpiryDate());
		stm.setObject(6,ca1.getCcv());
		
		int res = stm.executeUpdate();
		
		return res>0;
	}

	@Override
	public ArrayList<CashPayment> getCashPaymentInfo(int cashPID) throws SQLException {
		// TODO Auto-generated method stub
		String sql = "select * from cashpayment where cashPID  = '"+cashPID+"'";
		Statement stm = conn.createStatement();
		ResultSet rst = stm.executeQuery(sql);
		
		ArrayList<CashPayment> list = new ArrayList<CashPayment>();
		while(rst.next()) {
			CashPayment c1 = new CashPayment();
			
			c1.setCashPID(rst.getInt("cashPID"));
			c1.setAmount(rst.getString("amount"));
			c1.setDeliveryDate(rst.getString("deliveryDate"));
			c1.setDeliveryAddress(rst.getString("deliveryAddress"));
	
			list.add(c1);
		}
		return list;
	}

	@Override
	public ArrayList<ChequePayment> getChequePaymentInfo(int chequePID) throws SQLException {
		// TODO Auto-generated method stub
		String sql = "select * from chequepayment where chequePID  = '"+chequePID+"'";
		Statement stm = conn.createStatement();
		ResultSet rst = stm.executeQuery(sql);
		
		ArrayList<ChequePayment> list = new ArrayList<ChequePayment>();
		while(rst.next()) {	
			ChequePayment ch1= new ChequePayment();
			
			ch1.setChequePID(rst.getInt("chequePID"));
			ch1.setAmount(rst.getString("amount"));
			ch1.setChequeNumber(rst.getString("chequeNumber"));
			ch1.setBank(rst.getString("bank"));
			
			list.add(ch1);
		}
		return list;
	}

	@Override
	public ArrayList<CardPayment> getCardPaymentInfo(int cardPID) throws SQLException {
		// TODO Auto-generated method stub
		String sql = "select * from cardpayment where cardPID  = '"+cardPID+"'";
		Statement stm = conn.createStatement();
		ResultSet rst = stm.executeQuery(sql);
		
		ArrayList<CardPayment> list = new ArrayList<CardPayment>();
		while(rst.next()) {
			CardPayment ca1= new CardPayment();
			
			ca1.setCardPID(rst.getInt("cardPID"));
			ca1.setAmount(rst.getString("amount"));
			ca1.setCardType(rst.getString("cardType"));
			ca1.setCardNumber(rst.getString("cardNumber"));
			ca1.setExpiryDate(rst.getString("expiryDate"));
			ca1.setCcv(rst.getString("ccv"));
			
			list.add(ca1);
		}
		return list;
	}	

}
