package chap2_MVC;

import java.util.Scanner;

public class cafeView {
	//cafeModel이라는 클래스를 가지고 오기 위해 멤버변수로 카페 모델을 추가함
	public cafeModel model;
	
	//model 매개변수를 받을 수 있는 생성자를 만들어줘야함
	public cafeView(cafeModel model) {
		this.model = model;
	}
	public void addcafeName() {
		Scanner sc = new Scanner(System.in);
		System.out.println("카페 정보를 입력하세요.");
		System.out.println("상호명 :");
		
		String name = sc.nextLine();
		System.out.println("카페주소 :");
		
		String address = sc.nextLine();
		System.out.println("카페연락처 :");
		String phoneNumber = sc.nextLine();
		
		System.out.println("운영시간 :");
		String operatingHours = sc.nextLine();
		
		//카페 모델에서 insertCafe라는 메서드를 가지고 와야 함
		model.insertCafe(name, address, phoneNumber, operatingHours);
		System.out.println("카페가 성공적으로 추가되었습니다.");
	}
	public void updateMenu() {
		Scanner sc = new Scanner(System.in);
		System.out.println("메뉴 설명을 업데이트 하세요.");
		
		System.out.print("메뉴 ID : ");
		int menuId = sc.nextInt();
		//System.out.print("카페 ID :");
		//int cafeId = sc.nextInt();
		System.out.println("수정할 메뉴 설명: ");
		String descrition = sc.next();
		
		model.updateMenu(descrition, menuId);
		System.out.println("메뉴 설명이 성공적으로 업데이트되었습니다.");
	
		
	}
	public void updateCafe() {
		Scanner sc = new Scanner(System.in);
		System.out.println("운영시간을 업데이트하세요.");
		
		System.out.print("카페 ID :");
		int cafeId = sc.nextInt();
		System.out.println("수정할 운영시간 작성: ");
		String OPERATING_HOURS = sc.next();
		
		model.updateCafe(OPERATING_HOURS, cafeId);
		System.out.println("운영시간이 업데이트되었습니다.");
		
	}
	public void selctCafe() {
		Scanner sc = new Scanner(System.in);
		System.out.println("번호별 카페 정보를 확인하세요");
		System.out.println("카페 ID:");
		int CAFE_ID = sc.nextInt();
		model.selctCafe(CAFE_ID);
		System.out.println("업데이트 됬습니다.");
		//while(true) {
		//if()
		//}
	}
	public void deleteCafe() {
		Scanner sc = new Scanner(System.in);
		System.out.println("제거하고 싶은 카페id를 입력하세요");
		int cafeid = Integer.parseInt(sc.nextLine());//string으로 받은값을 int로 출력할때
		model.deleteCafe(cafeid);
		System.out.println("카페정보가 제거되었습니다.");
	}
	public void findCafe() {
		Scanner sc = new Scanner(System.in);
		System.out.println("찾고싶은 카페의 지역을 입력하세요");
		String find = sc.next();
		model.findCafe(find);
		}
	public void deleteMenu() {
		Scanner sc = new Scanner(System.in);
		System.out.println("제거하고 싶은 카페id를 입력하세요");
		int cafeid = Integer.parseInt(sc.nextLine());//string으로 받은값을 int로 출력할때
		model.deleteCafe(cafeid);
		System.out.println("메뉴정보가 제거되었습니다.");
}
	public void selectMenu() {
		Scanner sc = new Scanner(System.in);
		System.out.println("카페정보.");
		String menu = sc.next();
		model.selctMenu(menu);
		
		
		//System.out.println("됬나요");
	}
}
