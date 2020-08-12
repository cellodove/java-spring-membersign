package min.simplemember.template;

import java.util.List;

import min.simplemember.model.MemberDTO;

public interface MemberDaoService {
	// 전체 회원 검색한다.
	List<MemberDTO> getMemberList();
	
	// 회원 로그인
	public void login(String id, String pass);

	// 회원 추가한다.
	public void add(String id, String pass, String name, int age);

	// 회원 수정한다.
	public void update(String id, String pass, String name, int age);

	// 회원 삭제한다.
	public void remove(String id);
}