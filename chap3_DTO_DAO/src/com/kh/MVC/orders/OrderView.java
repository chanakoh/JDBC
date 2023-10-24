package com.kh.MVC.orders;

import java.util.List;

public class OrderView {

	public void showOredrList(List<OrderDTO> orders) {
		for(OrderDTO o : orders) {
			System.out.println("����id"+o.getOrder_id());
			System.out.println("�� ����"+o.getTotal_price());
			System.out.println("=========================");
		}
	}
	
	public void showTotalPrice(double totalPrice) {
		System.out.println("�� ����"+totalPrice);
	}
}
