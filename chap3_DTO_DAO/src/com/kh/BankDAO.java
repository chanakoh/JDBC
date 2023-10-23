package com.kh;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.SQLException;

public class BankDAO {
	private Connection connection;
	public BankDAO(Connection connection) {
		this.connection = connection;
}
	
	public void plusBank( Double balance,String account_number ) throws SQLException {
	String sql = "UPDATE BANK SET BALANCE = ? WHERE ACCOUNT_NUMBER = ? ";
	PreparedStatement ps = connection.prepareStatement(sql);
	ps.setDouble(1, balance);
	System.out.println(ps);
	ps.setString(2, account_number);
	System.out.println(ps);
    int update = ps.executeUpdate();
	System.out.println("입급이 완료되었습니다.");
	}
	
	/*public void minusBank(Double balance,String account_number) throws SQLException {
	String sql = "UPDATE BANK SET BALANCE = BALANCE - ? WHERE ACCOUNT_NUMBER = ? ";
	PreparedStatement ps = connection.prepareStatement(sql);
	ps.setDouble(1, balance);
	ps.setString(2, account_number);
	ps.executeUpdate();
	System.out.println("송금이 완료되었습니다.");
	}*/
	
}
