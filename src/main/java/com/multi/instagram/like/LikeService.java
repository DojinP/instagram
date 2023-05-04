package com.multi.instagram.like;

import java.util.List;

import com.multi.instagram.board.BoardDTO;

public interface LikeService{
	
	List<LikeDTO> read(String userId, String boardId);
	
	int count(String likeId);
	List<LikeDTO> select (int boardId, int userId);
	int insert(int boardId, int userId);
	List<BoardDTO> Like_List(int userId);

}
