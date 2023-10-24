package com.kh.MVC.orders;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.PreparedStatement;
import java.sql.SQLException;
import java.util.ArrayList;
import java.util.List;

import com.kh.MVC.ProductsAdd.ProductDTO;

public class Orderone {

	public static void main(String[] args) throws SQLException {
		String jdbcurl = "jdbc:oracle:thin:@localhost:1521:xe";
		String username = "khcafe";
		String password = "KHCAFE";
		Connection con = DriverManager.getConnection(jdbcurl, username, password);
		PreparedStatement st = con.prepareStatement("SELECT * FROM products");
		List<ProductDTO> products = new ArrayList<>();
		
	
	}

}
