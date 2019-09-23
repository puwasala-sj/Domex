package Util;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.SQLException;

public class myDB {
	private static Connection conn;
	public static Connection getDBconection() {
		if(conn == null) {
			try {
				Class.forName("com.mysql.jdbc.Driver");
				conn = DriverManager.getConnection("jdbc:mysql://localhost:3306/domex","root","");
			}catch(SQLException | ClassNotFoundException e) {
				e.printStackTrace();
			}
		}
		return conn;
	}

}
