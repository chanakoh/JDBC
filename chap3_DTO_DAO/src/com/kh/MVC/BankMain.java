package com.kh.MVC;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.SQLException;

public class BankMain {
	public static void main(String[] args) throws SQLException {
	String jdbcurl = "jdbc:oracle:thin:@localhost:1521:xe";
	String username = "khbank";
	String password = "kh1234";
	Connection con = DriverManager.getConnection(jdbcurl, username, password);
	BankModel bmo = new BankModel(con);
	BankView view = new BankView();
	view.displaybank();
	bmo.bankwork();
	}
}