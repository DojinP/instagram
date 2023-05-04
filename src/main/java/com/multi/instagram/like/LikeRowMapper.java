package com.multi.instagram.like;

import java.sql.ResultSet;
import java.sql.SQLException;

import org.springframework.jdbc.core.RowMapper;

public class LikeRowMapper implements RowMapper<LikeDTO>{

	@Override
	public LikeDTO mapRow(ResultSet rs, int rowNum) throws SQLException {
		System.out.println(rowNum);
		LikeDTO like = new LikeDTO(rs.getInt(1), rs.getInt(2));
		return like;
	}

}
