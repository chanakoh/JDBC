package com.kh;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.PreparedStatement;
import java.sql.SQLException;

public class Banksum {
	private static Connection connection;
	public Banksum(Connection connection) {
		this.connection = connection;
	}
	
public void sumBank(Double balance, String account_number) {
	String sql = "UPDATE BANK SET BALANCE = ? WHERE ACCOUNT_NUMBER = ?";
	try {
		PreparedStatement st = connection.prepareStatement(sql);
		st.setDouble(1,balance);
		st.setString(2,account_number);
		st.executeUpdate();
		System.out.println("업데이트가 완료되었습니다.");
	} catch (SQLException e) {
		// TODO Auto-generated catch block
		e.printStackTrace();
	}
	
}
	public static void main(String[] args) throws SQLException {
		String jdbcURL = "jdbc:oracle:thin:@localhost:1521:xe";
		String dbUserName = "khbank";
		String dbPassWord = "kh1234";
		Connection connection = DriverManager.getConnection(jdbcURL, dbUserName, dbPassWord);
		Banksum sum = new Banksum(connection);
	
		sum.sumBank(600.00, "9876543219");
	}

}
