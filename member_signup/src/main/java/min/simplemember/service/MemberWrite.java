package min.simplemember.service;

import java.util.List;
import java.util.Scanner;

import org.springframework.context.ApplicationContext;
import org.springframework.context.support.GenericXmlApplicationContext;

import min.simplemember.control.MemberAction;
import min.simplemember.dao.MemberDAO;
import min.simplemember.model.MemberDTO;

public class MemberWrite implements MemberAction {

	@Override
	public void execute(Scanner scanner) {
		
		// 절대 경로를 지정하여 설정 파일 정보를 읽어 온다.
		ApplicationContext context = new GenericXmlApplicationContext("file:src/main/webapp/WEB-INF/spring/root-context.xml");
		// Bean 객체를 호출한다.
		MemberDAO memberDAO = (MemberDAO) context.getBean("memberDAO");
		
		System.out.println("회원가입");
		System.out.println("이름을 입력하세요");
		String name = scanner.next();
		System.out.println("사용할 아이디를 입력하세요");
		String id = scanner.next();
		System.out.println("사용할 비밀번호를 입력하세요");
		String pass = scanner.next();
		System.out.println("나이를 입력하세요");
		int age = scanner.nextInt();
		
		memberDAO.add(id,pass,name,age);
		List<MemberDTO> list = memberDAO.getMemberList();
		System.out.println();
		System.out.println(list);
		
		
	}

}
