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
		System.out.println("������ id�� �Է��ϼ���");
		int fromAccountID = sc.nextInt();
		System.out.println("���۹��� id�� �Է��ϼ���");
		int toAccountID = sc.nextInt();
		System.out.println("������ �ݾ��� �Է��ϼ���.");
		double amount = sc.nextDouble();
		
	}
}
