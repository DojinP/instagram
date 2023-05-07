package com.multi.instagram.dm;

import java.sql.ResultSet;
import java.sql.SQLException;

import org.springframework.jdbc.core.RowMapper;

public class DMRowMapper implements RowMapper<DMDTO>{

	@Override
	public DMDTO mapRow(ResultSet rs, int rowNum) throws SQLException {
		DMDTO DM = new DMDTO(rs.getInt(1), rs.getString(2), rs.getString(3));
		return DM;
	}
}