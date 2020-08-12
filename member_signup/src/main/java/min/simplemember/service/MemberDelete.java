package min.simplemember.service;

import java.util.List;
import java.util.Scanner;

import org.springframework.context.ApplicationContext;
import org.springframework.context.support.GenericXmlApplicationContext;

import min.simplemember.control.MemberAction;
import min.simplemember.dao.MemberDAO;
import min.simplemember.model.MemberDTO;

public class MemberDelete implements MemberAction {

	@Override
	public void execute(Scanner scanner) {
		// 절대 경로를 지정하여 설정 파일 정보를 읽어 온다.
		ApplicationContext context = new GenericXmlApplicationContext("file:src/main/webapp/WEB-INF/spring/root-context.xml");
		// Bean 객체를 호출한다.
		MemberDAO memberDAO = (MemberDAO) context.getBean("memberDAO");
		
		System.out.println("삭제할 아이디를 입력하세요");
		String id = scanner.next();
		memberDAO.remove(id);
		List<MemberDTO> list = memberDAO.getMemberList( );
		System.out.println();
		System.out.println(list);
	}
}
