package com.kh.dtoSample;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.SQLException;

public class ProductsMain {

	public static void main(String[] args) {
		String url = "jdbc:oracle:thin:@localhost:1521:xe"; // 연결할 sql위치 및 id,pw작성
		String username = "khcafe";
		String password = "KHCAFE";
		
		try {
			Connection con = DriverManager.getConnection(url, username, password); // 연결작업
			ProductsView view = new ProductsView(); // 컨트롤러 사용을 위한 출력을 위한 view 객체생성 및  초기화
			ProductsController controller = new ProductsController(con,view); // 컨트롤러 객체생성 및 초기화
			controller.displayAllProducts(); // 마지막 자료값 출력
		
		} catch (SQLException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
	}

}
