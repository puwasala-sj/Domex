package Model;

import java.sql.*;

public class RegularClient {

	//attributes
		private int clientId;
		private String addressNo, lane, street, town ,city, province;
		private String email;
		private String contactNo;
		private String firstName, lastName;
		private String nic;
		private String postalCode;
		
		//constructors
		
		public RegularClient(int clientId, String addressNo, String lane, String street, String town, String city,
				String province, String email, String contactNo, String firstName, String lastName, String nic,
				String postalCode) {

			this.clientId = clientId;
			this.addressNo = addressNo;
			this.lane = lane;
			this.street = street;
			this.town = town;
			this.city = city;
			this.province = province;
			this.email = email;
			this.contactNo = contactNo;
			this.firstName = firstName;
			this.lastName = lastName;
			this.nic = nic;
			this.postalCode = postalCode;
		}

		//methods
		
		public RegularClient(){}
		/**
		 * @return the clientId
		 */
		public int getClientId() {
			return clientId;
		}

		/**
		 * @param clientId the clientId to set
		 */
		public void setClientId(int clientId) {
			this.clientId = clientId;
		}

		/**
		 * @return the addressNo
		 */
		public String getAddressNo() {
			return addressNo;
		}

		/**
		 * @param addressNo the addressNo to set
		 */
		public void setAddressNo(String addressNo) {
			this.addressNo = addressNo;
		}

		/**
		 * @return the lane
		 */
		public String getLane() {
			return lane;
		}

		/**
		 * @param lane the lane to set
		 */
		public void setLane(String lane) {
			this.lane = lane;
		}

		/**
		 * @return the street
		 */
		public String getStreet() {
			return street;
		}

		/**
		 * @param street the street to set
		 */
		public void setStreet(String street) {
			this.street = street;
		}

		/**
		 * @return the town
		 */
		public String getTown() {
			return town;
		}

		/**
		 * @param town the town to set
		 */
		public void setTown(String town) {
			this.town = town;
		}

		/**
		 * @return the city
		 */
		public String getCity() {
			return city;
		}

		/**
		 * @param city the city to set
		 */
		public void setCity(String city) {
			this.city = city;
		}

		/**
		 * @return the province
		 */
		public String getProvince() {
			return province;
		}

		/**
		 * @param province the province to set
		 */
		public void setProvince(String province) {
			this.province = province;
		}

		/**
		 * @return the email
		 */
		public String getEmail() {
			return email;
		}

		/**
		 * @param email the email to set
		 */
		public void setEmail(String email) {
			this.email = email;
		}

		/**
		 * @return the contactNo
		 */
		public String getContactNo() {
			return contactNo;
		}

		/**
		 * @param contactNo the contactNo to set
		 */
		public void setContactNo(String contactNo) {
			this.contactNo = contactNo;
		}

		/**
		 * @return the firstName
		 */
		public String getFirstName() {
			return firstName;
		}

		/**
		 * @param firstName the firstName to set
		 */
		public void setFirstName(String firstName) {
			this.firstName = firstName;
		}

		/**
		 * @return the lastName
		 */
		public String getLastName() {
			return lastName;
		}

		/**
		 * @param lastName the lastName to set
		 */
		public void setLastName(String lastName) {
			this.lastName = lastName;
		}

		/**
		 * @return the nic
		 */
		public String getNic() {
			return nic;
		}

		/**
		 * @param nic the nic to set
		 */
		public void setNic(String nic) {
			this.nic = nic;
		}

		/**
		 * @return the postalCode
		 */
		public String getPostalCode() {
			return postalCode;
		}

		/**
		 * @param postalCode the postalCode to set
		 */
		public void setPostalCode(String postalCode) {
			this.postalCode = postalCode;
		}

		//Fetch results - 1 row
		
		public RegularClient (ResultSet resultSet) throws SQLException {
			
			this.firstName = resultSet.getString("first_name");
			this.lastName = resultSet.getString("last_name");
			this.nic = resultSet.getString("nic");
			this.addressNo = resultSet.getString("house_no");
			this.lane = resultSet.getString("lane");
			this.street = resultSet.getString("street");
			this.town = resultSet.getString("town");
			this.city = resultSet.getString("city");
			this.province = resultSet.getString("province");
			this.lane = resultSet.getString("lane");
			this.email = resultSet.getString("email");
			this.contactNo = resultSet.getString("contact_no");
			this.postalCode = resultSet.getString("postal_code");
			
		}
		
		
		

}
