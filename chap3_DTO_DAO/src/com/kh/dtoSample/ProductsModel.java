package com.kh.dtoSample;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;
import java.util.List;

public class ProductsModel {

private Connection connection; // iv
public ProductsModel(Connection connection) { // 생성자, 초기화시켜줌
	this.connection = connection;
}

public List<ProductsDTO> getProducts(){         //SQL에서 원하는 값을 지정하는 작업. List를 통해 int,String상관없이 전부 가져올 수 있음
	List<ProductsDTO> products = new ArrayList<>(); //List 객체 생성
	String query = "SELECT * FROM products"; // sql에서 가져올 자료 제정
	try {
		PreparedStatement st = connection.prepareStatement(query);
		//st.setString(1,"PRODUCT_NAME");
		ResultSet result = st.executeQuery(); // select한 값 지정
		while(result.next()) { // 반복문을 통해 1개 가져온 문구를 다음문구를 가져옴
			ProductsDTO pro = new ProductsDTO(); // pro객체 생성
			pro.setProductid(result.getInt("product_id")); //DTO클래스에서 만든메서드를 통해 iv를 간접적으로 가져옴
			pro.setProductname(result.getString("product_name"));
			pro.setCategory(result.getString("category"));
			pro.setPrice(result.getDouble("price"));
			pro.setStockqyantity(result.getInt("stock_quantity"));
			products.add(pro); //list에 자료 추가
		}
	} catch (SQLException e) {
		// TODO Auto-generated catch block
		e.printStackTrace();
	}
	return products; // 모든 자료 출력 후에 products객체에 만들어진 값 반환
}

}

