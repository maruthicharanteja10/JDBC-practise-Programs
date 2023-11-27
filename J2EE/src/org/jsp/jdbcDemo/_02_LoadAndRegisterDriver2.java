package org.jsp.jdbcDemo;

public class _02_LoadAndRegisterDriver2 {
	public static void main(String[] args) {
		try {
			Class.forName("com.mysql.cj.jdbc.Driver");
			System.out.println("Driver class is loaded and registered");
		} catch (ClassNotFoundException e) {

			e.printStackTrace();
		}
	}
}
