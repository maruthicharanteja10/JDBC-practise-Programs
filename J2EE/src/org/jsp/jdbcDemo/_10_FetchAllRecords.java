package org.jsp.jdbcDemo;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;

public class _10_FetchAllRecords {
	public static void main(String[] args) {
		Connection con = null;
		Statement st = null;
		ResultSet rs = null;
		try {
			Class.forName("com.mysql.cj.jdbc.Driver");
			con = DriverManager.getConnection("jdbc:mysql://localhost:3306/jdbc_demo", "root", "charantej@@18");
			st = con.createStatement();
//			rs=st.executeQuery("select * from person");
			boolean res = st.execute("select * from person");
			if (res) {
				rs = st.getResultSet();
			}
			while (rs.next()) {
				System.out.println("Id:" + rs.getInt(1));// rs.getInt("id")
				System.out.println("Name:" + rs.getString("name"));// rs.getString(2)
				System.out.println("phoneno:" + rs.getLong("phone"));// rs.getLong(3)
				System.out.println("Passoword:" + rs.getString(4));// rs.getString("password")
				System.out.println("------******------");
			}
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
			if (rs != null) {
				try {
					rs.close();
				} catch (SQLException e) {
					e.printStackTrace();
				}
			}
		}
	}
}
