package min.simplemember.view;

import java.util.Scanner;
import min.simplemember.service.*;

public class MemberMain {
	public static void main(String[] args) {
		boolean isStop = false;
		Scanner scanner = new Scanner(System.in);
		do {
			System.out.println();
			System.out.println("다음 메뉴 중 하나를 입력하세요.");
			System.out.print("1.회원 로그인" + " ");
			System.out.print("2.회원 목록 보기" + " ");
			System.out.print("3.회원 정보 등록" + " ");
			System.out.print("4.회원 정보 수정" + " ");
			System.out.print("5.회원 정보 삭제" + " ");
			System.out.println("6.종료");
			System.out.println();
			System.out.print("메뉴 번호 입력 : ");
			String menu = scanner.next();
			switch (menu) {
			case "1":
				MemberLogin memberLogin = new MemberLogin();
				memberLogin.execute(scanner);
				break;
			case "2":
				MemberList memberList = new MemberList();
				memberList.execute(scanner);
				break;
			case "3":
				MemberWrite memberWrite = new MemberWrite();
				memberWrite.execute(scanner);
				break;
			case "4":
				MemberUpdate memberUpdate = new MemberUpdate();
				memberUpdate.execute(scanner);
				break;
			case "5":
				MemberDelete memberDelete = new MemberDelete();
				memberDelete.execute(scanner);
				break;
			case "6":
				isStop = true;
				System.out.println("프로그램을 종료합니다.");
			}
		} while (!isStop);
	}
}