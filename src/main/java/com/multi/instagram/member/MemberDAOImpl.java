package com.multi.instagram.member;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.jdbc.core.JdbcTemplate;
import org.springframework.stereotype.Repository;

@Repository
public class MemberDAOImpl implements MemberDAO {
	@Autowired
	JdbcTemplate template;
	
	@Override
	public int signup(MemberDTO member) {
		System.out.println("회원가입 시행  - DAO " + member.getPass() + " ");
		String sql = "insert into member_table values (null, ?, ?, ?, null, null, ?, null, null, null, sysdate())";
		return template.update(sql, member.getPass(),
									 member.getName(),
									 member.getNickname(),
									 member.getEmail());
	}

	@Override
	public MemberDTO login(MemberDTO member) {
		System.out.println("로그인 시행  - DAO");
		String sql = "select * from member_table where member_email = ? and member_pw = ?";
		System.out.println(member.getEmail()+","+member.getPass());
		return template.queryForObject(sql, new Object[] {member.getEmail(), member.getPass()}, new MemberRowMapper());
	}
	
	@Override
	public int update(MemberDTO member) {
		System.out.println("업데이트 시행 - DAO");
		String sql = "update member_table set member_pw=?, member_nickname=?"
										+ ", member_gender=?, member_birthday=?, member_email=?"
										+ ", member_tel=?, member_website=?, member_introduction=?";
		return template.update(sql, member.getPass(), member.getNickname(), member.getGender(),
									member.getBirthday(), member.getEmail(), member.getTel(),
									member.getWebsite(), member.getIntroduction());
	}
	
	@Override
	public int delete(MemberDTO member) {
		String sql = "delete from member_table where member_id=?";
		return template.update(sql, member.getId());
	}
	
	// Board 관련
	@Override
	public List<MemberDTO> member_list() {
		return template.query("select * from member_table", new MemberRowMapper());
	}

	
	// Follow 관련
	@Override
	public MemberDTO read(String member_id) {
		String sql = "select * from member_table where member_id=?";
		return template.queryForObject(sql, new Object[] {member_id}, new MemberRowMapper());
	}
	
	//유세희 - 추가 member_id를 비교해서 nickname을 가져오기 위한 작업
	@Override
	public String member_nick(String member_id) {
		return template.queryForObject("select member_nickname from member_table where member_id = ? ",
							new Object[] {member_id}, String.class);
	}

}
