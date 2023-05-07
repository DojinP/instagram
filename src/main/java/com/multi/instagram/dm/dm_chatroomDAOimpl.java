package com.multi.instagram.dm;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.jdbc.core.JdbcTemplate;
import org.springframework.stereotype.Repository;

@Repository
public class dm_chatroomDAOimpl implements dm_chatroomDAO {
	@Autowired
	JdbcTemplate template;

	@Override
	public int insert(int dmId, String sender, String content) {
		String sql = "insert into dm_message_table values(null,?,?,?,null)";
		return template.update(sql,dmId,sender, content);
	}

	@Override
	public java.util.List<dm_chatroomDTO> List(int dmid) {
		String sql = "select * from dm_message_table where dm_id =?";
		
		return template.query(sql, new Object[] {dmid},new ChatRowMapper());
	}

}
