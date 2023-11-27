package org.jsp.jdbcDemo;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.PreparedStatement;
import java.sql.SQLException;
import java.util.Scanner;

public class _14_DeletePersonByPS {
	public static void main(String[] args) {
		Connection con = null;
		PreparedStatement pst = null;
		Scanner s = new Scanner(System.in);
		System.out.println("Enter the id to delete");
		int id = s.nextInt();
		String update_qry = "delete from person  where id=?";
		try {
			Class.forName("com.mysql.cj.jdbc.Driver");
			con = DriverManager.getConnection("jdbc:mysql://localhost:3306/jdbc_demo", "root", "charantej@@18");
			pst = con.prepareStatement(update_qry);
			
			pst.setInt(1, id);
			int r = pst.executeUpdate();
			System.out.println(r + "rows are deleted");

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
