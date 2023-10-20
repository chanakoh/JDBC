package com.kh.dtoSample;
// CafeDTO : ������ ���� ��ü
public class CafeDTO {
	//model sql �� ���Ŀ� ���� �����͸� ĸ��ȭ�ϰ� getter setter�� Ȱ���Ͽ� 
	//�����͸� �����ϰ� �������� ����
	
	//�ʵ� ������� �ۼ�
	private int cafeId;
	private String cafeName;
	private String address;
	private String phoneNuber;
	private String operatingHours;
	
	//������
	//1. �⺻ ������
	
	public CafeDTO(){}
	//2. �Ķ���� ���� ���� ������
	public CafeDTO(int cafeID, String cafeName, String address, String phoneNumber, String operatingHours) {
	this.cafeId = cafeID;
	this.cafeName = cafeName;
	this.address = address;
	this.phoneNuber = phoneNumber;
	this.operatingHours = operatingHours;
	
	} 
	//Getter Setter �޼���
	public int getCafeId() {
		return cafeId;
	}
	public void setCafeId(int cafeId) {
		this.cafeId = cafeId;
	}
	public String getCafeName() {
		return cafeName;
	}
	public void setCafeName(String cafeName) {
		this.cafeName = cafeName;
	}
	public String getAddress() {
		return address;
	}
	public void setAddress(String address) {
		this.address = address;
	}
	public String getPhoneNuber() {
		return phoneNuber;
	}
	public void setPhoneNuber(String phoneNuber) {
		this.phoneNuber = phoneNuber;
	}
	public String getOperatingHours() {
		return operatingHours;
	}
	public void setOperatingHours(String operatingHours) {
		this.operatingHours = operatingHours;
	}
	
	//@Override�� Ȱ���� toString �޼��� �߰�
	@Override
	public String toString() {
		return "CafeDTO";
	}
}
