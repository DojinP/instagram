package com.multi.instagram.dm;

import java.sql.ResultSet;
import java.sql.SQLException;

import org.springframework.dao.DataAccessException;
import org.springframework.jdbc.core.ResultSetExtractor;
import org.springframework.jdbc.core.RowMapper;

public class ChatRowMapper implements RowMapper<dm_chatroomDTO> {

	@Override
	public dm_chatroomDTO mapRow(ResultSet rs, int rowNum) throws SQLException {
		dm_chatroomDTO chat = new dm_chatroomDTO(rs.getInt(1), rs.getInt(2), rs.getString(3),rs.getString(4),rs.getDate(5));
		return chat;
	}
}
