package com.kh.db.oracledb.CRUD;

import java.sql.Connection;
import java.sql.Date;
import java.sql.DriverManager;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;


public class selectSample {

	public static void main(String[] args) {
		//selectBank();
		//selectKhcafe();
		//selectIf();
		//insertBank();
		//createBank2();
		insertOne();
	}
 
 static void insertOne() {
	String url = "jdbc:oracle:thin:@localhost:1521:xe";	
	String user = "khbank";
	String password = "kh1234";
	try {
		Connection con = DriverManager.getConnection(url, user, password);
		String insertQuery = "INSERT INTO BANK (account_id, account_number, account_name, balance, branch_name, last_transaction_date)"
							+"VALUES (?,?,?,?,?,?)";
		PreparedStatement insertState = con.prepareStatement(insertQuery);
		insertState.setInt(1, 5);
		insertState.setString(2, "9876543");
		insertState.setString(3, "사아자");
		insertState.setDouble(4,1500.00);
		insertState.setString(5,"kh뱅크");
		insertState.setDate(6,Date.valueOf("2023-10-19"));
		
		int rowsInsert = insertState.executeUpdate();
		System.out.println(rowsInsert+"row추가");
	} catch (SQLException e) {
		// TODO Auto-generated catch block
		e.printStackTrace();
	}
 	}
 
 static void insertkhcafe() {
	 String url = "jdbc:oracle:thin:@localhost:1521:xe";	
		String user = "khcafe";
		String password = "KHCAFE";
		try {
			Connection con = DriverManager.getConnection(url, user, password);
			String insertQuery = "INSERT INTO CAFES (CAFE_ID, C_NAME, ADDRESS, PHONE_NUMBER, OPERATING_HOURS)"
					+"VALUES (?,?,?,?,?)";
PreparedStatement insertState = con.prepareStatement(insertQuery);
insertState.setInt(1, 21);
insertState.setString(2,"잘나가는카페");
insertState.setString(3,"대전시 서구");
insertState.setString(4,"042-455-5454");
insertState.setString(5,"매일: 09:00-22:00");
		
int rowsInsert = insertState.executeUpdate();
System.out.println("rowsInsert"+rowsInsert);
		} catch (SQLException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		} 
 }
}
