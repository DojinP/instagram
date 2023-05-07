package com.multi.instagram.dm;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.jdbc.core.JdbcTemplate;
import org.springframework.stereotype.Repository;

import com.multi.instagram.member.MemberDTO;
import com.multi.instagram.member.MemberRowMapper;

@Repository
public class DMDAOimpl implements DMDAO {
	@Autowired
	JdbcTemplate template;
	@Override
	public List<DMDTO> select(DMDTO dto) {
		return template.query("select * from direct_message_table", new DMRowMapper());
	}
	@Override
	public List<MemberDTO> listuser(String member_name) {
		String memberid = member_name+"%";
		System.out.println(memberid);
		return template.query("select * from member_table WHERE member_name LIKE ?",new Object[] {memberid} ,new MemberRowMapper());
	}
	@Override
	public List<DMDTO> boardlist(int user_id) {
		String sql = "select * from direct_message_table where sender_id = ? or receiver_id = ?";
		return template.query(sql,new Object[] {user_id, user_id},new DMRowMapper());
	}
	@Override
	public int insert(int sender, int opponent) {
		String sql = "insert into direct_message_table values(null,?,?)";
		return template.update(sql,sender,opponent);
	}
}
