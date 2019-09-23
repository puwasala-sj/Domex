package Model;

import java.sql.Date;

public class CashPayment{
	private int cashPID;
	private String amount;
	private String deliveryDate;
	private String deliveryAddress;
	
	public CashPayment() {
		super();
	}

	public CashPayment(int cashPID, String amount, String deliveryDate, String deliveryAddress) {
		super();
		this.cashPID = cashPID;
		this.amount = amount;
		this.deliveryDate = deliveryDate;
		this.deliveryAddress = deliveryAddress;
	}

	public int getCashPID() {
		return cashPID;
	}

	public void setCashPID(int cashPID) {
		this.cashPID = cashPID;
	}

	public String getAmount() {
		return amount;
	}

	public void setAmount(String amount) {
		this.amount = amount;
	}

	public String getDeliveryDate() {
		return deliveryDate;
	}

	public void setDeliveryDate(String deliveryDate) {
		this.deliveryDate = deliveryDate;
	}

	public String getDeliveryAddress() {
		return deliveryAddress;
	}

	public void setDeliveryAddress(String deliveryAddress) {
		this.deliveryAddress = deliveryAddress;
	}

}
