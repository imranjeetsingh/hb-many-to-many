package com.ranjeet.hibernate;

import java.sql.Connection;
import java.sql.DriverManager;

public class TestJdbc {

	public static void main(String[] args) {
		// TODO Auto-generated method stub
		String jdbcUrl = "jdbc:mysql://localhost:3306/hb-05-many-to-many?useSSL=false&serverTimeTimeZone=UTC";
		String user = "hbstudent";
		String pass = "hbstudent";
		try {
			System.out.println("Connecting to database"+jdbcUrl);
			Connection conn = DriverManager.getConnection(jdbcUrl,user,pass);
			System.out.println("Connection succesfull");
		}
		catch(Exception exc) {
			exc.printStackTrace();
		}
	}

}
