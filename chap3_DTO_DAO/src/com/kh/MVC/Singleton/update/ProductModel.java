package com.kh.MVC.Singleton.update;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.PreparedStatement;
import java.sql.SQLException;

import com.kh.MVC.Singleton.Product.ProductsDTO;
import com.kh.MVC.Singleton.Product.ProductsModel;

public class ProductModel {
	private static Connection connection;
	private static ProductModel productModel = null;
	private static String DB_URL = "jdbc:oracle:thin:@localhost:1521:xe";
	private static String id = "khcafe";
	private static String pw = "KHCAFE";
	private ProductModel() {}
	
	public static ProductModel getInstance() throws SQLException {
		if(productModel == null) {
			productModel = new ProductModel();
			connection = DriverManager.getConnection(DB_URL, id, pw);
		}
		return productModel;
	}
	
	public boolean insertProduct(ProductDTO product) {
		String sql = "UPDATE PRODUCTS SET CATEGORY = ? WHERE PRODUCT_ID = ?";
		
		try {
			PreparedStatement ps = connection.prepareStatement(sql);
			//ps.setString(2, product.getProductname());
			ps.setString(1, product.getCategory());
			ps.setInt(2,product.getProductId());
			//ps.setDouble(4, product.getPrice());
			//ps.setInt(5, product.getStockqyantity());
			int rowsAffected = ps.executeUpdate();
			return rowsAffected > 0;
		} catch (SQLException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		return false;
	}


}
	
