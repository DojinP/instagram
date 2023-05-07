package com.multi.instagram.like;

import java.sql.Date;
import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Repository;

import com.multi.instagram.board.BoardDTO;
import com.multi.instagram.board.BoardFileDTO;

@Repository
public interface LikeDAO {
	int delete(String likeId);
	List<LikeDTO> read(String userId, String boardId);
	
	int count(String likeId);//좋아요 개수
	int insert_like(int boardId, int userId);
	List<LikeDTO> select_like(int boardId, int userId);
	List<BoardDTO> like_List(int userId);
	//추가
	List<BoardFileDTO> select_like_board(int userId);
	//추가
	List<LikeDTO> select_like_user(int userId);

}