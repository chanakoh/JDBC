package com.kh.MVC;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.PreparedStatement;
import java.sql.SQLException;

public class BankModel {
	private Connection con;
	
	public BankModel(Connection con) {
		this.con = con;
		
	}
	

public void bankwork(BankView bv) throws SQLException {
	
	PreparedStatement a = con.prepareStatement("UPDATE BANK SET balance = balance - ? WHERE ACCOUNT_ID = ?");
	a.setDouble(1,bv.amount);
	a.setInt(2,bv.fromAccountID);
	a.executeUpdate();
	
	PreparedStatement b = con.prepareStatement("UPDATE BANK SET balance = balance + ? Where account_id = ?");
	b.setDouble(1,bv.amount);
	b.setInt(2, bv.toAccountID);
	b.executeUpdate();
}
}
