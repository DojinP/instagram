package com.multi.instagram.board;

import java.util.List;

public interface BoardDAO {
	int insertBoard(BoardDTO board);
	int insertFile(List<BoardFileDTO> boardfiledtolist);
	
	List<BoardDTO> selectBoard();
	List<BoardFileDTO> selectFile();

	List<BoardFileDTO> selectLikeFile(int boardId);
	
	BoardUploadDTO readBoard(String boardId, String writerId);

	int deleteBoard(String boardId);
	int deleteBoardFile(String boardId);
	
	int updateBoard(String boardContent, String boardId);
}
