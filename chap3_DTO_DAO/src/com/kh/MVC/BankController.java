package com.kh.MVC;

import java.sql.Connection;

public class BankController {
	private BankModel model;
	private BankView view;
	
	public BankController(Connection con, BankView view) {
		this.model = new BankModel(con);
		this.view = view;
	}
	public void displayBank() {
		
	}
}
