package org.jsp.jdbcAssignment;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.PreparedStatement;
import java.sql.SQLException;
import java.util.Scanner;

public class _04_deleteRecordwithphonenoAndPsswd {
	public static void main(String[] args) {
		Connection con = null;
		PreparedStatement pst = null;
		Scanner s = new Scanner(System.in);
		System.out.println("Enter the phoneno and password to delete");
		Long phone = s.nextLong();
		String password = s.next();

		String update_qry = "delete from person  where phone=? and password=?";
		try {
			Class.forName("com.mysql.cj.jdbc.Driver");
			con = DriverManager.getConnection("jdbc:mysql://localhost:3306/jdbc_demo", "root", "charantej@@18");
			pst = con.prepareStatement(update_qry);

			pst.setLong(1, phone);
			pst.setString(2, password);
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