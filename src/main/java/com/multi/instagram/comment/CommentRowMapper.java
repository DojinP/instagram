package com.multi.instagram.comment;

import java.sql.ResultSet;
import java.sql.SQLException;

import org.springframework.jdbc.core.RowMapper;

public class CommentRowMapper implements RowMapper<CommentDTO> {
	@Override
	public CommentDTO mapRow(ResultSet rs, int rowNum) throws SQLException {
		return new CommentDTO(rs.getString(1),
							  rs.getString(2),
							  rs.getString(3),
							  rs.getString(4),
							  rs.getString(5));
	}
}
