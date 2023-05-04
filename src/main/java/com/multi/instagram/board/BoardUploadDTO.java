package com.multi.instagram.board;

import java.sql.Date;

public class BoardUploadDTO {
	private int boardId;
	private String boardContent;
	private Date boardTimestamp;
	private String storeFilename;
	private String memberNickname;
	
	public BoardUploadDTO() {
		super();
	}

	public BoardUploadDTO(int boardId, String boardContent, Date boardTimestamp, String storeFilename,
			String memberNickname) {
		super();
		this.boardId = boardId;
		this.boardContent = boardContent;
		this.boardTimestamp = boardTimestamp;
		this.storeFilename = storeFilename;
		this.memberNickname = memberNickname;
	}

	@Override
	public String toString() {
		return "BoardUploadDTO [boardId=" + boardId + ", boardContent=" + boardContent + ", boardTimestamp="
				+ boardTimestamp + ", storeFilename=" + storeFilename + ", memberNickname=" + memberNickname + "]";
	}

	public int getBoardId() {
		return boardId;
	}

	public void setBoardId(int boardId) {
		this.boardId = boardId;
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

	public String getStoreFilename() {
		return storeFilename;
	}

	public void setStoreFilename(String storeFilename) {
		this.storeFilename = storeFilename;
	}

	public String getMemberNickname() {
		return memberNickname;
	}

	public void setMemberNickname(String memberNickname) {
		this.memberNickname = memberNickname;
	}
	
	
	
}
