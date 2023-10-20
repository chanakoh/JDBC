package com.kh.MVC.Singleton.Product;

import java.sql.SQLException;
import java.util.List;
import java.util.Scanner;

public class ProductsView {
	//public void addProducts() {
		//Scanner
	//}
	/*
	public void displayProducts(List<ProductsDTO> products) { //ProductsDTO리스트 값을 사용하기 위해 products변수로 지정
		for(ProductsDTO p : products) { //향상된 for문으로 전부 출력
			System.out.println("PRODUCT_ID"+p.getProductid()); // Model에서 setProdctsid에 지정된 자료값을 getproductsid값을 통해 가져옴
			System.out.println("PRODUCT_NAME"+p.getProductname());
			System.out.println("CATEGORY"+p.getCategory());
			System.out.println("PRICE"+p.getPrice());
			System.out.println("STOCK_QUANTITY"+p.getStockqyantity());
		}
	}*/
	public void addProdcut() {
		Scanner sc = new Scanner(System.in);
		System.out.println("새 제품정보를 입력하세요.");
		
		System.out.println("제품id:");
		int productid = sc.nextInt();
		
		System.out.println("제품이름:");
		String productname = sc.next();
		
		System.out.println("카테고리:");
		String category = sc.next();
		
		System.out.println("가격:");
		double price = sc.nextDouble();
		
		System.out.println("재고수량:");
		int stockqyantity = sc.nextInt();
		
		//Scanner로 받은 제품내용을 새로 추가하기
		
		ProductsDTO newProduct = new ProductsDTO(productid,productname,category,price,stockqyantity);
			ProductsModel productModel;
			boolean success = false;
			try {
				productModel = ProductsModel.getInstance();
				success = productModel.insertProduct(newProduct);
			} catch (SQLException e) {
				// TODO Auto-generated catch block
				e.printStackTrace();
			}
		if(success) {
			System.out.println("제품이 성공적으로 추가되었습니디");
		} else {
			System.out.println("제품 추가 중 오류가 발생했습니다.");
		}
		sc.close();
		}
}
	
