package com.kh.dtoSample;

import java.sql.SQLException;
import java.util.List;
import java.util.Scanner;

public class ProductsView {
	//public void addProducts() {
		//Scanner
	//}
	
	public void displayProducts(List<ProductsDTO> products) { //ProductsDTO����Ʈ ���� ����ϱ� ���� products������ ����
		for(ProductsDTO p : products) { //���� for������ ���� ���
			System.out.println("PRODUCT_ID"+p.getProductid()); // Model���� setProdctsid�� ������ �ڷᰪ�� getproductsid���� ���� ������
			System.out.println("PRODUCT_NAME"+p.getProductname());
			System.out.println("CATEGORY"+p.getCategory());
			System.out.println("PRICE"+p.getPrice());
			System.out.println("STOCK_QUANTITY"+p.getStockqyantity());
		}
	}
}
	
