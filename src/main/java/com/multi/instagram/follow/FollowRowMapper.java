package com.multi.instagram.follow;

import java.sql.ResultSet;
import java.sql.SQLException;

import org.springframework.jdbc.core.RowMapper;

public class FollowRowMapper implements RowMapper<FollowDTO>{

	@Override
	public FollowDTO mapRow(ResultSet rs, int rowNum) throws SQLException {
		System.out.println(rowNum);
		FollowDTO follow = new FollowDTO(rs.getString(1), rs.getString(2), rs.getString(3));
		return follow;
	}

}