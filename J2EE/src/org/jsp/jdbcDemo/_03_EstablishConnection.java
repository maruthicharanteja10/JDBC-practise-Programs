package org.jsp.jdbcDemo;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.SQLException;
public class _03_EstablishConnection {
	public static void main(String[] args) {
		Connection con = null;
		try {
			Class.forName("com.mysql.cj.jdbc.Driver");
			System.out.println("Driver loaded and Registered ");
			con = DriverManager.getConnection("jdbc:mysql://localhost:3306?user=root&password=charantej@@18");
			System.out.println("Connetion is established");
			con = DriverManager.getConnection("jdbc:mysql://localhost:3306", "root", "charantej@@18");
		} catch (ClassNotFoundException | SQLException e) {
			e.printStackTrace();
		} finally {
			if (con != null) {
				try {
					con.close();
					System.out.println("connection closed");
				} catch (SQLException e) {
					e.printStackTrace();
				}
			}
		}
	}
}
