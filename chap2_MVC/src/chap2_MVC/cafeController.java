package chap2_MVC;

import java.util.Scanner;

public class cafeController {
	public cafeModel model;
	public cafeView view;
	
	//모델과 뷰를 가지고올생성자 만들어주기
	public cafeController(cafeModel model, cafeView view) {
		this.model = model;
		this.view = view;
	}
	public void run() {
		boolean isTrue = true;
		while(isTrue) {
		Scanner sc = new Scanner(System.in);
		//선택할 번호 출력 메서드로 입력
		System.out.println("1. 카페 정보 추가");
		System.out.println("2. 메뉴 설명 추가");
		System.out.println("3. 종료");
		System.out.println("원하는 작업을 선택해주세요.");
		
		int choice = sc.nextInt();
		switch(choice) {
		case 1:
			view.addcafeName();
			break;
		case 2:
			view.updateMenu();
			break;
		case 3:
			System.out.println("프로그램을 종료합니다.");
			isTrue = false;
			break;
		default:
			System.out.println("올바른 번호를 입력하세요.");
		}
	}
	}
}
