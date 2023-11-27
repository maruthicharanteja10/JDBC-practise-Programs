package org.jsp.jdbcDemo;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.SQLException;
import java.sql.Statement;

public class _07_InsertRecordsInPerson {
	public static void main(String[] args) {
		Connection con = null;
		Statement st = null;
		String qry = "insert into person values(1,'tej',8787837,'tej@123')";
		try {
			Class.forName("com.mysql.cj.jdbc.Driver");
			con = DriverManager.getConnection("jdbc:mysql://localhost:3306/jdbc_demo", "root", "charantej@@18");
			st = con.createStatement();
			st.execute(qry);
//			st.execute("insert into person values(2,'jos',2165761,'jos@123')");
			System.out.println("Record is inserted in person table");
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