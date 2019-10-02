package Model;

public class User {
	
	//attributes
	private String username;
	private String password;
	private String role;
	private int userId;
	private int status;
	
	public User() {} //default
	
	public User(String username, String password, String role, int userId, int status) {
		super();
		this.username = username;
		this.password = password;
		this.role = role;
		this.userId = userId;
		this.status = status;
	}//overloaded constructors

	//getters and setters
	public String getUsername() {
		return username;
	}

	public void setUsername(String username) {
		this.username = username;
	}

	public String getPassword() {
		return password;
	}

	public void setPassword(String password) {
		this.password = password;
	}

	public String getRole() {
		return role;
	}

	public void setRole(String role) {
		this.role = role;
	}

	public int getUserId() {
		return userId;
	}

	public void setUserId(int userId) {
		this.userId = userId;
	}

	public int getStatus() {
		return status;
	}

	public void setStatus(int status) {
		this.status = status;
	}
	
	
	

}//end of class
