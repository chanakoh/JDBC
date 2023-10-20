package com.kh.dtoSample;
// CafeDTO : 데이터 전송 객체
public class CafeDTO {
	//model sql 열 형식에 맞춰 데이터를 캡슐화하고 getter setter를 활용하여 
	//데이터를 저장하고 내보내는 공간
	
	//필드 멤버변수 작성
	private int cafeId;
	private String cafeName;
	private String address;
	private String phoneNuber;
	private String operatingHours;
	
	//생성자
	//1. 기본 생성자
	
	public CafeDTO(){}
	//2. 파라미터 값을 받을 생성자
	public CafeDTO(int cafeID, String cafeName, String address, String phoneNumber, String operatingHours) {
	this.cafeId = cafeID;
	this.cafeName = cafeName;
	this.address = address;
	this.phoneNuber = phoneNumber;
	this.operatingHours = operatingHours;
	
	} 
	//Getter Setter 메서드
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
	
	//@Override를 활용한 toString 메서드 추가
	@Override
	public String toString() {
		return "CafeDTO";
	}
}
