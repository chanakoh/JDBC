package com.kh.db.oracledb.CRUD;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.PreparedStatement;
import java.sql.SQLException;

public class deleteSample {

	public static void main(String[] args) throws SQLException {
		String jdbcurl = "jdbc:oracle:thin:@localhost:1521:xe";
		String username = "khbank";
		String password = "kh1234";
		
		Connection con = DriverManager.getConnection(jdbcurl, username, password);
		String deleteQuery = "DELETE FROM BANK WHERE account_id = ?";
		PreparedStatement deletePs = con.prepareStatement(deleteQuery);
		deletePs.setDouble(1,2);
		int rowsUpdate = deletePs.executeUpdate();
		System.out.println(rowsUpdate+"삭제되었습니다.");
		
	}

}
