package org.jsp.jdbcDemo;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.SQLException;
import java.sql.Statement;

public class _04_CreateStatement {
	public static void main(String[] args) {
		Connection con = null;
		Statement st = null;
		String url = "jdbc:mysql://localhost:3306";
		String user = "root", password = "charantej@@18";
		try {
			Class.forName("com.mysql.cj.jdbc.Driver");
			System.out.println("Connection established");
			con = DriverManager.getConnection(url, user, password);
			System.out.println("Platform created");
		} catch (ClassNotFoundException | SQLException e) {
			e.printStackTrace();
		} finally {
			if (con != null) {
				try {
					con.close();
					System.out.println("Connection closed");
				} catch (SQLException e) {
					e.printStackTrace();
				}
			}
			if (st != null) {
				try {
					st.close();
					System.out.println("Statement closed");
				} catch (SQLException e) {
					e.printStackTrace();
				}
			}
		}
	}
}
