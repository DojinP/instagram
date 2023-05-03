package com.multi.instagram.board;

import java.util.ArrayList;
import java.util.List;

public interface BoardAbstractService {
	int createBoard(String boardcontext);
	List<BoardDTO> selectBoard();


}
