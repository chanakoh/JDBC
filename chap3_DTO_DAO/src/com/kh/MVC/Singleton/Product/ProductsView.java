package com.kh.MVC.Singleton.Product;

import java.sql.SQLException;
import java.util.List;
import java.util.Scanner;

public class ProductsView {
	//public void addProducts() {
		//Scanner
	//}
	/*
	public void displayProducts(List<ProductsDTO> products) { //ProductsDTO����Ʈ ���� ����ϱ� ���� products������ ����
		for(ProductsDTO p : products) { //���� for������ ���� ���
			System.out.println("PRODUCT_ID"+p.getProductid()); // Model���� setProdctsid�� ������ �ڷᰪ�� getproductsid���� ���� ������
			System.out.println("PRODUCT_NAME"+p.getProductname());
			System.out.println("CATEGORY"+p.getCategory());
			System.out.println("PRICE"+p.getPrice());
			System.out.println("STOCK_QUANTITY"+p.getStockqyantity());
		}
	}*/
	public void addProdcut() {
		Scanner sc = new Scanner(System.in);
		System.out.println("�� ��ǰ������ �Է��ϼ���.");
		
		System.out.println("��ǰid:");
		int productid = sc.nextInt();
		
		System.out.println("��ǰ�̸�:");
		String productname = sc.next();
		
		System.out.println("ī�װ�:");
		String category = sc.next();
		
		System.out.println("����:");
		double price = sc.nextDouble();
		
		System.out.println("������:");
		int stockqyantity = sc.nextInt();
		
		//Scanner�� ���� ��ǰ������ ���� �߰��ϱ�
		
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
			System.out.println("��ǰ�� ���������� �߰��Ǿ����ϵ�");
		} else {
			System.out.println("��ǰ �߰� �� ������ �߻��߽��ϴ�.");
		}
		sc.close();
		}
}
	
