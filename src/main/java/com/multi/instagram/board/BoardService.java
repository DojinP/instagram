package com.multi.instagram.board;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.SQLException;
import java.util.ArrayList;
import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.annotation.Qualifier;
import org.springframework.stereotype.Service;

@Service("BoardService")
public class BoardService implements BoardAbstractService{

	@Autowired
	BoardDAO dao;
	
	@Override
	public int createBoard(String boardcontext) {
		return dao.insertBoard(boardcontext);
	}

	@Override
	public List<BoardDTO> selectBoard() {
		return dao.selectBoard();
	}

	

}
