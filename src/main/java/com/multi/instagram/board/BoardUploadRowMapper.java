package com.multi.instagram.board;

import java.sql.ResultSet;
import java.sql.SQLException;

import org.springframework.jdbc.core.RowMapper;

public class BoardUploadRowMapper implements RowMapper<BoardUploadDTO>{

	@Override
	public BoardUploadDTO mapRow(ResultSet rs, int rowNum) throws SQLException {
		BoardUploadDTO boardUpload = new BoardUploadDTO(rs.getInt(1), rs.getString(2), rs.getDate(3), rs.getString(4), rs.getString(5));
		return boardUpload;
	}
	
}
