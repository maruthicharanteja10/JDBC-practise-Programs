package org.jsp.jdbcDemo;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.PreparedStatement;
import java.sql.SQLException;
import java.sql.Statement;

public class _12_InsertMultipleRecordsByPreparedStatement {
	public static void main(String[] args) {
		Connection con = null;
		PreparedStatement pst = null;
		try {
			Class.forName("com.mysql.cj.jdbc.Driver");
			con = DriverManager.getConnection("jdbc:mysql://localhost:3306/jdbc_demo", "root", "charantej@@18");
			pst = con.prepareStatement("insert into person values(?,?,?,?)");
			pst.setInt(1,201);
			pst.setString(2, "virat");
			pst.setLong(3,66777);
			pst.setString(4, "RCB");
			pst.executeUpdate();
			pst.setInt(1,202);
			pst.setString(2, "dhoni");
			pst.setLong(3,89898);
			pst.setString(4, "CSK");
			pst.executeUpdate();
			pst.setInt(1,203);
			pst.setString(2, "rohith");
			pst.setLong(3,99933);
			pst.setString(4, "MI");
			pst.executeUpdate();
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
			if (pst != null) {
				try {
					pst.close();
				} catch (SQLException e) {
					e.printStackTrace();
				}
			}
		}
	}
}
