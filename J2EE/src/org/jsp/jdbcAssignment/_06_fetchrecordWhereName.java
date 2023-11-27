package org.jsp.jdbcAssignment;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.Scanner;

public class _06_fetchrecordWhereName {
	public static void main(String[] args) {
		Connection con = null;
		PreparedStatement pst = null;
		ResultSet rs = null;
		String query="select * from person where name=?";
		Scanner s = new Scanner(System.in);
		System.out.println("Enter the name to fetch the records:");
		String name = s.next();
		try {
			Class.forName("com.mysql.cj.jdbc.Driver");
			con=DriverManager.getConnection("jdbc:mysql://localhost:3306/jdbc_demo", "root", "charantej@@18");
			pst=con.prepareStatement(query);
			pst.setString(1, name);
			rs=pst.executeQuery();
			while(rs.next()) {
				System.out.println("Id : " + rs.getInt(1));
				System.out.println("Name :" + rs.getString(2));
				System.out.println("Phoneno : " + rs.getLong(3));
				System.out.println("Password : " + rs.getString(4));
			}
		} catch (ClassNotFoundException|SQLException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		finally {
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
