package com.kh.dtoSample;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.SQLException;

public class ProductsMain {

	public static void main(String[] args) {
		String url = "jdbc:oracle:thin:@localhost:1521:xe"; // ������ sql��ġ �� id,pw�ۼ�
		String username = "khcafe";
		String password = "KHCAFE";
		
		try {
			Connection con = DriverManager.getConnection(url, username, password); // �����۾�
			ProductsView view = new ProductsView(); // ��Ʈ�ѷ� ����� ���� ����� ���� view ��ü���� ��  �ʱ�ȭ
			ProductsController controller = new ProductsController(con,view); // ��Ʈ�ѷ� ��ü���� �� �ʱ�ȭ
			controller.displayAllProducts(); // ������ �ڷᰪ ���
		
		} catch (SQLException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
	}

}
