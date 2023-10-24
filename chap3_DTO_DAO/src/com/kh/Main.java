package com.kh;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.SQLException;

public class Main {

	public static void main(String[] args) throws SQLException {
		String jdbcURL = "jdbc:oracle:thin:@localhost:1521:xe";
		String dbUserName = "khbank";
		String dbPassWord = "kh1234";
		
		Connection connection = DriverManager.getConnection(jdbcURL, dbUserName, dbPassWord);
		BankDAO bankdao = new BankDAO(connection);
		
		bankdao.plusBank(700.00,"9876543219");
		
		//bankdao.minusBank(500.01, "3333444555");
	}

}
