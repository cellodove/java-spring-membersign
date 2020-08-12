package min.simplemember.dao;

import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.jdbc.core.JdbcTemplate;
import org.springframework.jdbc.core.RowMapper;
import org.springframework.stereotype.Repository;

import min.simplemember.model.MemberDTO;
import min.simplemember.template.MemberDaoService;

@Repository
public class MemberDAO implements MemberDaoService {
	@Autowired
	private JdbcTemplate jdbcTemplate;

	@Override
	public List<MemberDTO> getMemberList() {
		String sql = "select id, pass, age, name from simplemember";
		// query 메소드로 SQL 문의 select 문을 실행한다.
		return jdbcTemplate.query(sql, new RowMapper<MemberDTO>() {
			// ResultSet 인터페이스로 결과를 반환한다.
			@Override
			public MemberDTO mapRow(ResultSet resultSet, int deptno) throws SQLException {
				MemberDTO MemberDTO = new MemberDTO();
				MemberDTO.setId(resultSet.getString("id"));
				MemberDTO.setPass(resultSet.getString("pass"));
				MemberDTO.setAge(resultSet.getInt("age"));
				MemberDTO.setName(resultSet.getString("name"));
				return MemberDTO;
			}
		});

	}

	@Override
	public void login(String id, String pass) {
		String sql = "select * from simplemember";
		sql += " where id = ? and pass = ?";
		
	}

	@Override
	public void add(String id, String pass, String name, int age) {
		String sql = "insert into simplemember (id,pass,age,name) ";
		sql += " values (?,?,?,?)";
		// update 메소드로 SQL 문의 insert 문을 실행한다.
		jdbcTemplate.update(sql, id, pass, age,name);
		System.out.println("추가 되었습니다.");
	}

	@Override
	public void update(String id, String pass, String name, int age) {
		String sql = "update simplemember set pass = ?, age = ?, name=? ";
		sql += " where id = ?";
		// update 메소드로 SQL 문의 update 문을 실행한다.
		jdbcTemplate.update(sql, pass, age,name,id);
		System.out.println("수정 되었습니다.");
	}

	@Override
	public void remove(String id) {
		String sql = "delete from simplemember ";
		sql += " where id= ?";
		// update 메소드로 SQL 문의 delete 문을 실행한다.
		jdbcTemplate.update(sql, id);
		System.out.println("삭제되었습니다.");
	}
}
