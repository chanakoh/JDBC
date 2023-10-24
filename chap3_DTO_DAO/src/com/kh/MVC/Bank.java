package com.kh.MVC;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.PreparedStatement;
import java.sql.SQLException;
import java.util.Scanner;

public class Bank {
	public static void main(String[] args) throws SQLException {
		String jdbcurl = "jdbc:oracle:thin:@localhost:1521:xe";
		String username = "khbank";
		String password = "kh1234";
		Connection con = DriverManager.getConnection(jdbcurl, username, password);
		Scanner sc = new Scanner(System.in);
		System.out.println("������ id�� �Է��ϼ���");
		int fromAccountID = sc.nextInt();
		System.out.println("���۹��� id�� �Է��ϼ���");
		int toAccountID = sc.nextInt();
		
		System.out.println("������ �ݾ��� �Է��ϼ���.");
		double amount = sc.nextDouble();
		
		con.setAutoCommit(false); 
		PreparedStatement a = con.prepareStatement("UPDATE BANK SET balance = balance - ? WHERE ACCOUNT_ID = ?" );
		a.setDouble(1,amount);
		a.setInt(2, fromAccountID);
		a.executeUpdate();
		con.commit();
		
		PreparedStatement b = con.prepareStatement("UPDATE BANK SET balance = balance + ? Where account_id = ?");
		b.setDouble(1, amount);
		b.setInt(2, toAccountID);
		b.executeUpdate();
		con.commit();
		
}
}
