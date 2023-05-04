package com.multi.instagram.board;

import java.sql.ResultSet;
import java.sql.SQLException;

import org.springframework.jdbc.core.RowMapper;

public class BoardFileRowMapper implements RowMapper<BoardFileDTO>{

	@Override
	public BoardFileDTO mapRow(ResultSet rs, int rowNum) throws SQLException {
		BoardFileDTO boardfile = new BoardFileDTO(rs.getInt(1), rs.getString(2), rs.getString(3), rs.getString(4));
		return boardfile;
	}
	
}
