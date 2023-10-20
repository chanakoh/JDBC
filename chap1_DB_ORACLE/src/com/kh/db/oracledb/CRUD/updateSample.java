package com.kh.db.oracledb.CRUD;

import java.sql.Connection;
import java.sql.Date;
import java.sql.DriverManager;
import java.sql.PreparedStatement;
import java.sql.SQLException;

public class updateSample {

	public static void main(String[] args) throws SQLException {
		String jdbcurl = "jdbc:oracle:thin:@localhost:1521:xe";
		String username = "khbank";
		String password = "kh1234";
		Connection con = DriverManager.getConnection(jdbcurl, username, password);
		
		String ipdateQuery = "UPDATE BANK SET balance = ? WHERE LAST_TRANSACTION_DATE = ?";
		PreparedStatement updatePs = con.prepareStatement(ipdateQuery);
		updatePs.setDouble(1,3000.01);
		updatePs.setDate(2,Date.valueOf("2023-10-10"));
		
		int rowsUpdate = updatePs.executeUpdate();
		System.out.println(rowsUpdate+"update되었습니다.");
		
	}

}
