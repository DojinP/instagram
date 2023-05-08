package com.multi.instagram.board;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.SQLException;
import java.util.ArrayList;
import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.annotation.Qualifier;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

@Service("BoardService")
public class BoardService implements BoardAbstractService{

	@Autowired
	BoardDAO dao;
	
	@Override
	public int insertBoard(BoardDTO board) {
		return dao.insertBoard(board);
	}

	@Transactional(rollbackFor = Exception.class)
	@Override
	public int insertBoard(BoardDTO board, List<BoardFileDTO> boardfiledtolist) {
		dao.insertBoard(board);
		dao.insertFile(boardfiledtolist);
		return 0;
	}

	@Override
	public List<BoardDTO> selectBoard() {
		return dao.selectBoard();
	}
	
	@Override
	public List<BoardFileDTO> selectLikeFile(int boardId) {

		return dao.selectLikeFile(boardId);
	}
	
	@Override
	public List<BoardFileDTO> selectFile() {
		return dao.selectFile();
	}

	@Override
	public int deleteBoard(String boardId) {
		dao.deleteBoard(boardId);
		dao.deleteBoardFile(boardId);
		return 0;
	}

	@Override
	public BoardUploadDTO readBoard(String boardId, String writerId) {
		// TODO Auto-generated method stub
		return dao.readBoard(boardId, writerId);
	}

	@Override
	public int update(String boardContent, String boardId) {
		return dao.updateBoard(boardContent, boardId);
	}
	

}
