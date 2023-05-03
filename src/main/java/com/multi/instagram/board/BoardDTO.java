package com.multi.instagram.board;

import java.sql.Date;

public class BoardDTO {
	private int boardId;
	private String writerId;
	private String boardContent;
	private Date boardTimestamp;
	
	public BoardDTO() {
		
	}
	
	//update
	public BoardDTO(int boardId, String boardContent) {
		super();
		this.boardId = boardId;
		this.boardContent = boardContent;
	}

	//insert
	public BoardDTO(String writerId, String boardContent) {
		super();
		this.writerId = writerId;
		this.boardContent = boardContent;
	}

	//select
	public BoardDTO(int boardId, String writerId, String boardContent, Date boardTimestamp) {
		super();
		this.boardId = boardId;
		this.writerId = writerId;
		this.boardContent = boardContent;
		this.boardTimestamp = boardTimestamp;
	}

	@Override
	public String toString() {
		return "BoardDTO [boardId=" + boardId + ", writerId=" + writerId
				+ ", boardContent=" + boardContent + ", boardTimestamp=" + boardTimestamp + "]";
	}

	//getter & setter
	public int getBoardId() {
		return boardId;
	}

	public void setBoardId(int boardId) {
		this.boardId = boardId;
	}

	public String getWriterId() {
		return writerId;
	}

	public void setWriterId(String writerId) {
		this.writerId = writerId;
	}

	public String getBoardContent() {
		return boardContent;
	}

	public void setBoardContent(String boardContent) {
		this.boardContent = boardContent;
	}

	public Date getBoardTimestamp() {
		return boardTimestamp;
	}

	public void setBoardTimestamp(Date boardTimestamp) {
		this.boardTimestamp = boardTimestamp;
	}
	
}
