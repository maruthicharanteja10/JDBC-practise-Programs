package org.jsp.jdbcDemo;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.SQLException;
import java.sql.Statement;

public class _11_InsertMultipleRecordsByStatement {
	public static void main(String[] args) {
		Connection con = null;
		Statement st = null;
		
		try {
			Class.forName("com.mysql.cj.jdbc.Driver");
			con = DriverManager.getConnection("jdbc:mysql://localhost:3306/jdbc_demo", "root", "charantej@@18");
			st = con.createStatement();
			st.executeUpdate("insert into person values(101,'tej',378873,'tej@123')");
			st.executeUpdate("insert into person values(102,'jos',88788,'jos@123')");
			st.executeUpdate("insert into person values(103,'cherry',9908873,'cherry@123')");
			System.out.println("3 records inserted succesfully");
			
		} catch (ClassNotFoundException | SQLException e) {
			e.printStackTrace();
		} finally {
			if (con != null) {
				try {
					con.close();
				} catch (SQLException e) {
					e.printStackTrace();
				}
			}
			if (st != null) {
				try {
					st.close();
				} catch (SQLException e) {
					e.printStackTrace();
				}
			}
		}
	}
}
