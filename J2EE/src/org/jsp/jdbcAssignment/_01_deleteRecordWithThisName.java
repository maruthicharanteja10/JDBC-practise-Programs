package org.jsp.jdbcAssignment;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.PreparedStatement;
import java.sql.SQLException;
import java.util.Scanner;

public class _01_deleteRecordWithThisName {
public static void main(String[] args) {
	Connection con = null;
	PreparedStatement pst = null;
	Scanner s = new Scanner(System.in);
	System.out.println("Enter the name to delete");
	String name = s.next();
	String update_qry = "delete from person  where name=?";
	try {
		Class.forName("com.mysql.cj.jdbc.Driver");
		con = DriverManager.getConnection("jdbc:mysql://localhost:3306/jdbc_demo", "root", "charantej@@18");
		pst = con.prepareStatement(update_qry);
		
		pst.setString(1, name);
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
