package org.jsp.jdbcDemo;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.Scanner;

public class _16_LoginValidationByUsingPhonenoAndPsswd {
	public static void main(String[] args) {
		Connection con = null;
		PreparedStatement pst = null;
		ResultSet rs = null;
		Scanner s = new Scanner(System.in);
		System.out.println("Enter the Phoneno and password: ");
		long phone = s.nextLong();
		String password = s.next();
		String query = "select * from person where phone=? and password=?";
		try {
			Class.forName("com.mysql.cj.jdbc.Driver");
			con = DriverManager.getConnection("jdbc:mysql://localhost:3306/jdbc_demo", "root", "charantej@@18");
			pst = con.prepareStatement(query);
			pst.setLong(1, phone);
			pst.setString(2, password);
			rs = pst.executeQuery();
			if (rs.next()) {
				System.out.println("person Verified Successfully");
				System.out.println("Id : " + rs.getInt(1));
				System.out.println("Name :" + rs.getString(2));
				System.out.println("Phoneno : " + rs.getLong(3));
				System.out.println("Password : " + rs.getString(4));
			} else {
				System.err.println("Invalid phoneno or password");
			}

		} catch (ClassNotFoundException | SQLException e) {

			e.printStackTrace();
		} finally {
			if (con != null) {
				try {
					con.close();
				} catch (SQLException e) {
					// TODO Auto-generated catch block
					e.printStackTrace();
				}
			}
			if (pst != null) {
				try {
					pst.close();
				} catch (SQLException e) {
					// TODO Auto-generated catch block
					e.printStackTrace();
				}
			}
			if (rs != null) {
				try {
					rs.close();
				} catch (SQLException e) {
					// TODO Auto-generated catch block
					e.printStackTrace();
				}

			}
		}
		s.close();
	}
}
