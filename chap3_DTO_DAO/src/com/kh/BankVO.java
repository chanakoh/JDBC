package com.kh;

import java.util.Date;

public class BankVO {
 private int account_id;
 private String account_number;
 private String account_name;
 private Double balance;
 private String branch_name;
 private Date last_transaction_date; 
 
 private BankVO() {}

 
 public int getAccount_id() {
	return account_id;
}
public String getAccount_number() {
	return account_number;
}
public String getAccount_name() {
	return account_name;
}
public Double getBalance() {
	return balance;
}
public String getBranch_name() {
	return branch_name;
}
public Date getLast_transaction_date() {
	return last_transaction_date;
}
public void setAccount_id(int account_id) {
	this.account_id = account_id;
}
public void setAccount_number(String account_number) {
	this.account_number = account_number;
}
public void setAccount_name(String account_name) {
	this.account_name = account_name;
}
public void setBalance(Double balance) {
	this.balance = balance;
}
public void setBranch_name(String branch_name) {
	this.branch_name = branch_name;
}
public void setLAST_TRANSACTION_DATE(Date last_transaction_date) {
	this.last_transaction_date = last_transaction_date;
}

 
}
