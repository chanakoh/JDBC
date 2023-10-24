package com.kh.MVC;

import java.util.Scanner;

public class BankView {
	int fromAccountID;
	int toAccountID;
	double amount;
	public BankView() {}
	public BankView(int fromAccountID, int toAccountID, double amount ) {
		this.fromAccountID = fromAccountID;
		this.toAccountID = toAccountID;
		this.amount = amount;
	}
	
	public void displaybank() {
		Scanner sc = new Scanner(System.in);
		System.out.println("전송할 id를 입력하세요");
		int fromAccountID = sc.nextInt();
		System.out.println("전송받을 id를 입력하세요");
		int toAccountID = sc.nextInt();
		System.out.println("전송할 금액을 입력하세요.");
		double amount = sc.nextDouble();
		
	}
}
