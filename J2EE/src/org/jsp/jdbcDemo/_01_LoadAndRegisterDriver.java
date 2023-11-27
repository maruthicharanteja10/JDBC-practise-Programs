package org.jsp.jdbcDemo;
import java.sql.DriverManager;
import java.sql.SQLException;
import com.mysql.cj.jdbc.Driver;
public class _01_LoadAndRegisterDriver {
	public static void main(String[] args) {
		
		try {
			Driver d = new Driver();
			DriverManager.registerDriver(d);
			System.out.println("Driver class loaded and registered successfully");
		} catch (SQLException e) {

			e.printStackTrace();
			System.err.println("Something went Wrong");
		}

	}
}
