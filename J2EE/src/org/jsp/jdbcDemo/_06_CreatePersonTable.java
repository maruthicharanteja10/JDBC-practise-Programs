package org.jsp.jdbcDemo;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.SQLException;
import java.sql.Statement;

public class _06_CreatePersonTable {
	public static void main(String[] args) {
		String qry = "create table person(id int not null,name varchar(45) not null,phone bigint(20) not null unique,password varchar(45) not null,primary key(id))";
		String url = "jdbc:mysql://localhost:3306/jdbc_Demo", user = "root", password = "charantej@@18";
		Connection con = null;
		Statement st = null;
		try {
			Class.forName("com.mysql.cj.jdbc.Driver");
			con = DriverManager.getConnection(url, user, password);
			st = con.createStatement();
			boolean res = st.execute(qry);
			System.out.println("Database Created");
			System.out.println(res);
		} catch (ClassNotFoundException | SQLException e) {
			e.printStackTrace();
		} finally {
			if (con != null) {
				try {
					con.close();
					System.out.println("Connection closed");
				} catch (SQLException e) {
					e.printStackTrace();
				}
			}
			if (st != null) {
				try {
					st.close();
					System.out.println("Statement closed");
				} catch (SQLException e) {
					e.printStackTrace();
				}
			}
		}
	}
}
