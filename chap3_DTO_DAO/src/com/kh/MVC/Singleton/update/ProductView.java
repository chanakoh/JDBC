package com.kh.MVC.Singleton.update;

import java.sql.SQLException;
import java.util.Scanner;

import com.kh.MVC.Singleton.Product.ProductsModel;

public class ProductView {

	public void updateProduct() {
		Scanner sc = new Scanner(System.in);
		System.out.println("수정하고 싶은 카테고리를 입력하세요.");
		System.out.println("제품id:");
		int productId = sc.nextInt();
		System.out.println("수정할 카테고리:");
		String category = sc.next();
		
		ProductDTO updateproduct = new ProductDTO(category,productId);
		ProductModel productModel;
		boolean success = false;
		try {
			productModel = ProductModel.getInstance();
			success = productModel.insertProduct(updateproduct);
		} catch (SQLException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		if(success) {
			System.out.println("업데이트가 완료되었습니다.");
		}else {
			System.out.println("업데이트가 실패하였습니다.");
		}
		sc.close();
		
	}
}
