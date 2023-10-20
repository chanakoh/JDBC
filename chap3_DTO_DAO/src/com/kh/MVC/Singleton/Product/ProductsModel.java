package com.kh.MVC.Singleton.Product;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;
import java.util.List;

public class ProductsModel {
	private static Connection connection;
	//Ŭ������ �ν��Ͻ��� �����ϴ� �̱��� ��ü
	private static ProductsModel productModel = null;
	private static String DB_URL = "jdbc:oracle:thin:@localhost:1521:xe";
	private static String id = "khcafe";
	private static String pw = "KHCAFE";
	//�⺻�����ڷκ��� �ܺο��� �ν��Ͻ��� ���� �����ϴ� ���� �����ϱ� ���� private�� ������
	private ProductsModel() {}
	//ProductModel Ŭ������ �ν��Ͻ��� ��ȯ�ϴ� �޼���
	//ó�� ȣ��� �� �����ͺ��̽��� ������ �����ϰ� ���� ȣ�⿡���� �̹� ������ �μ��Ͻ��� ��ȯ
	//�̱��� ������ �����ϴ� ���
	public static ProductsModel getInstance() throws SQLException {
		if(productModel == null) {
			productModel = new ProductsModel();
			connection = DriverManager.getConnection(DB_URL, id, pw);
		}
		return productModel;
	}

public boolean insertProduct(ProductsDTO product) {
	String sql = "INSERT INTO products (product_id, product_name, category, price, stock_quantity)"
			+"VALUES (?, ?, ?, ?, ?)";
try {
	PreparedStatement ps = connection.prepareStatement(sql);
	ps.setInt(1, product.getProductid());
	ps.setString(2, product.getProductname());
	ps.setString(3, product.getCategory());
	ps.setDouble(4, product.getPrice());
	ps.setInt(5, product.getStockqyantity());
	
	int rowsAffected = ps.executeUpdate();
	
	return rowsAffected > 0;
	
} catch (SQLException e) {
	// TODO Auto-generated catch block
	e.printStackTrace();
}
return false;

}	
}

