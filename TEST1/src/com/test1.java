package com;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;

public class test1 {

	public static void main(String[] args) {
		String driver = "orcale.jdbc.driver.OracleDriver";
		String url = "jdbc:oracle:thin:@localhost:1521:xe";
		String user = "KHCAFE";
		String password = "KHCAFE";
		Connection con = null;
		try {
			con = DriverManager.getConnection(url, user, password);
			System.out.println("데이터베이스 연결 성공!");
			
			String selectQuery = "SELECT * FROM MENU";
			PreparedStatement selectState = con.prepareCall(selectQuery);
			ResultSet result = selectState.executeQuery();
			System.out.println(result);
			while(result.next()) {
			int menuID = result.getInt("menu_id");
			System.out.println("menu_id : "+menuID);
			}
		} catch (SQLException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
}

	}

