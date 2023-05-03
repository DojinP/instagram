package com.multi.instagram.member;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.jdbc.core.JdbcTemplate;
import org.springframework.stereotype.Repository;

@Repository
public class MemberDAOImpl implements MemberDAO {
	@Autowired
	JdbcTemplate template;
	
	@Override
	public int signup(MemberDTO member) {
		System.out.println("회원가입 시행  - DAO");
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

}
