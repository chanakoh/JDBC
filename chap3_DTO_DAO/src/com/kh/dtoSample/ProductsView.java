package com.kh.dtoSample;

import java.sql.SQLException;
import java.util.List;
import java.util.Scanner;

public class ProductsView {
	//public void addProducts() {
		//Scanner
	//}
	
	public void displayProducts(List<ProductsDTO> products) { //ProductsDTO리스트 값을 사용하기 위해 products변수로 지정
		for(ProductsDTO p : products) { //향상된 for문으로 전부 출력
			System.out.println("PRODUCT_ID"+p.getProductid()); // Model에서 setProdctsid에 지정된 자료값을 getproductsid값을 통해 가져옴
			System.out.println("PRODUCT_NAME"+p.getProductname());
			System.out.println("CATEGORY"+p.getCategory());
			System.out.println("PRICE"+p.getPrice());
			System.out.println("STOCK_QUANTITY"+p.getStockqyantity());
		}
	}
}
	
