package com.multi.instagram.board;

import java.util.List;

public interface BoardDAO {
	int insertBoard(String boardcontext);
	int updateBoard(BoardDTO update);
	List<BoardDTO> selectBoard();
}
