package com.multi.instagram.like;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.multi.instagram.board.BoardDTO;
import com.multi.instagram.board.BoardFileDTO;

@Service
public class LikeServiceImpl implements LikeService{

	@Autowired
	LikeDAO dao;
	
	//추가
	@Override
	public List<BoardFileDTO> select_like_board(int userId) {
		
		return dao.select_like_board(userId);
	}
	//추가
	@Override
	public List<LikeDTO> select_like_user(int userId) {
		
		return dao.select_like_user(userId);
	}

	@Override
	public List<LikeDTO> read(String userId, String boardId) {
		
		return dao.read(userId, boardId);
	}


	@Override
	public int count(String likeId) {
		
		return dao.count(likeId);
	}


	@Override
	public int insert( int boardId, int userId) {
		
		return dao.insert_like(boardId,  userId);
	}


	@Override
	public List<LikeDTO> select(int boardId, int userId) {
		// TODO Auto-generated method stub
		return dao.select_like( boardId,userId);
	}


	@Override
	public List<BoardDTO> Like_List(int userId) {
		// TODO Auto-generated method stub
		return dao.like_List(userId);
	}

	

}
