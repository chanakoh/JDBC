package com.kh.MVC.Singleton.update;

public class ProductDTO {
	private String category;
	private int productId;
	//private String productName;
	
	//private Double price;
	//private int stockQyantity;
	
	public ProductDTO() {}   //기본생성자
	public ProductDTO(String category, int productId ) {
		this.category = category;
		this.productId = productId;
		//this.productName = productName;
		
	//	this.price = price;
		//this.stockQyantity = stockQyantity;
	}
	public void setProductId(int productId) {
		this.productId = productId;
	}
	public void setCategory(String category) {
		this.category = category;
	}
	public int getProductId() {
		return productId;
	}
	public String getCategory() {
		return category;
	}

	
}
