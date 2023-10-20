package com.kh.dtoSample;

import java.sql.Connection;
import java.util.List;

public class ProductsController {

	private ProductsModel model; //
	private ProductsView view;
	
	public ProductsController(Connection con, ProductsView view) { //생성자를 통해 모델과 뷰 초기화
		this.model = new ProductsModel(con);
		this.view = view;
	}
	
	public void displayAllProducts() { 
		List<ProductsDTO> products = model.getProducts(); // ProductsDTOLIST배열을 products변수로 지정하고 model멤버변수에getProducts를 통해 만들어준 자료값을 넣어준다 
		view.displayProducts(products); // 넣어준 자료값을 하나씩 출력하는 메서드
	}
}
