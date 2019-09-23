package Model;
import java.util.*;

public class Order {
	
	private int orderID;
	private String customer_Name;
	private String packages;
	private String type;
	private Float weight;
	private String receiver;
	private String address;
	private String district;
	private String town;
	private int postCode;
	private float charge;
	
	public Order() {
		super();
	}

	public Order(int orderID, String customer_Name, String packages, String type, Float weight, String receiver,
			String address, String district, String town, int postCode, float charge) {
		super();
		this.orderID = orderID;
		this.customer_Name = customer_Name;
		this.packages = packages;
		this.type = type;
		this.weight = weight;
		this.receiver = receiver;
		this.address = address;
		this.district = district;
		this.town = town;
		this.postCode = postCode;
		this.charge = charge;
	}

	public int getOrderID() {
		return orderID;
	}

	public void setOrderID(int orderID) {
		this.orderID = orderID;
	}

	public String getCustomer_Name() {
		return customer_Name;
	}

	public void setCustomer_Name(String customer_Name) {
		this.customer_Name = customer_Name;
	}

	public String getPackages() {
		return packages;
	}

	public void setPackages(String packages) {
		this.packages = packages;
	}

	public String getType() {
		return type;
	}

	public void setType(String type) {
		this.type = type;
	}

	public Float getWeight() {
		return weight;
	}

	public void setWeight(Float weight) {
		this.weight = weight;
	}

	public String getReceiver() {
		return receiver;
	}

	public void setReceiver(String receiver) {
		this.receiver = receiver;
	}

	public String getAddress() {
		return address;
	}

	public void setAddress(String address) {
		this.address = address;
	}

	public String getDistrict() {
		return district;
	}

	public void setDistrict(String district) {
		this.district = district;
	}

	public String getTown() {
		return town;
	}

	public void setTown(String town) {
		this.town = town;
	}

	public int getPostCode() {
		return postCode;
	}

	public void setPostCode(int postCode) {
		this.postCode = postCode;
	}

	public float getCharge() {
		return charge;
	}

	public void setCharge(float charge) {
		this.charge = charge;
	}

}
