package org.jsp.jdbcDemo;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.PreparedStatement;
import java.sql.SQLException;
import java.util.Scanner;

public class _13_UpdatePersonByPS {
	public static void main(String[] args) {
		Connection con = null;
		PreparedStatement pst = null;
		Scanner s = new Scanner(System.in);
		System.out.println("Enter the id to update");
		int id = s.nextInt();
		System.out.println("Enter name ,phone and password");
		String name = s.next();
		long phone = s.nextLong();
		String password = s.next();
		String update_qry = "update person set name=?,phone=?,password=? where id=?";
		try {
			Class.forName("com.mysql.cj.jdbc.Driver");
			con = DriverManager.getConnection("jdbc:mysql://localhost:3306/jdbc_demo", "root", "charantej@@18");
			pst = con.prepareStatement(update_qry);
			pst.setString(1, name);
			pst.setLong(2, phone);
			pst.setString(3, password);
			pst.setInt(4, id);
			int r = pst.executeUpdate();
			System.out.println(r + "rows are updated");

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
			if (pst != null) {
				try {
					pst.close();
				} catch (SQLException e) {
					e.printStackTrace();
				}
			}
			s.close();
		}
	}
}
