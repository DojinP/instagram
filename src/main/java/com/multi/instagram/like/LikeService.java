package com.multi.instagram.like;

import java.util.List;

import com.multi.instagram.board.BoardDTO;
import com.multi.instagram.board.BoardFileDTO;

public interface LikeService{
	
	List<LikeDTO> read(String userId, String boardId);
	
	int count(String likeId);
	List<LikeDTO> select (int boardId, int userId);
	int insert(int boardId, int userId);
	List<BoardDTO> Like_List(int userId);
	
	//추가
	List<BoardFileDTO> select_like_board(int userId);
	//추가
	List<LikeDTO> select_like_user(int userId);

}
