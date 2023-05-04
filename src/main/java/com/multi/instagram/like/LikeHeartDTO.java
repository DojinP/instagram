package com.multi.instagram.like;

public class LikeHeartDTO {
	
	private int likeId;
	private int boardId;
	private int userId;
	
	public LikeHeartDTO(int likeId, int boardId, int userId) {
		super();
		this.likeId = likeId;
		this.boardId = boardId;
		this.userId = userId;
	}
	
	@Override
	public String toString() {
		return "LikeHeartDTO [likeId=" + likeId + ", boardId=" + boardId + ", userId=" + userId + "]";
	}

	public int getLikeId() {
		return likeId;
	}

	public void setLikeId(int likeId) {
		this.likeId = likeId;
	}

	public int getBoardId() {
		return boardId;
	}

	public void setBoardId(int boardId) {
		this.boardId = boardId;
	}

	public int getUserId() {
		return userId;
	}

	public void setUserId(int userId) {
		this.userId = userId;
	}
	
	
}
