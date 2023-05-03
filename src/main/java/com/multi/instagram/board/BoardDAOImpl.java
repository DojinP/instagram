package com.multi.instagram.board;

import java.util.ArrayList;
import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.jdbc.core.JdbcTemplate;
import org.springframework.stereotype.Repository;

@Repository("BoardDAO")
public class BoardDAOImpl implements BoardDAO{

	@Autowired
	JdbcTemplate template;
	
	@Override
	public int insertBoard(String boardcontext) {
		String sql = "insert into board_table values(null,null,?,sysdate())";
		return template.update(sql, boardcontext);
	}

	@Override
	public List<BoardDTO> selectBoard() {
		return template.query("select * from board_table", new BoardRowMapper());
	}

	@Override
	public int updateBoard(BoardDTO update) {
		// TODO Auto-generated method stub
		return 0;
	}
	
}
