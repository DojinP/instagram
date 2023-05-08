package com.multi.instagram.like;

import java.sql.Date;

public class LikeDTO {
	
	private int likeId;
	private int boardId;
	private int userId;
	//추가
	private String storeFilename;
	
	public LikeDTO(int boardId, int userId) {
		super();
		this.likeId = likeId;
		this.boardId = boardId;
		this.userId = userId;
	}
	
	@Override
	public String toString() {
		return "LikeHeartDTO [likeId=" + likeId + ", boardId=" + boardId + ", userId=" + userId + "]";
	}
	//추가
	public String getStoreFilename() {
	     return storeFilename;
	}
	
	//추가
	public void setStoreFilename(String storeFilename) {
	     this.storeFilename = storeFilename;
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
	
	
//	private String hit;
//	private String heart;
//	//현재 사용자 좋아요 클릭 여부
//	private String hno;
//	//현재 사용자 즐겨찾기 클릭 여부
//	private String fno;
//	//글쓴이 프로필 사진
//	private String profile;
//	//현재 사용자 id
//	private int userId;
//	//시작 게시물 번호
//	private int startRowNum;
//	//끝 게시물 번호
//	private int endRowNum;
//	//가져갈 게시물 개수
//	private int rowCount;
//	
//	public LikeDTO(String hit, String heart, String hno, String fno, String profile, int userId, int startRowNum,
//			int endRowNum, int rowCount) {
//		super();
//		this.hit = hit;
//		this.heart = heart;
//		this.hno = hno;
//		this.fno = fno;
//		this.profile = profile;
//		this.userId = userId;
//		this.startRowNum = startRowNum;
//		this.endRowNum = endRowNum;
//		this.rowCount = rowCount;
//	}
//	public String getHit() {
//		return hit;
//	}
//	public void setHit(String hit) {
//		this.hit = hit;
//	}
//	public String getHeart() {
//		return heart;
//	}
//	public void setHeart(String heart) {
//		this.heart = heart;
//	}
//	public String getHno() {
//		return hno;
//	}
//	public void setHno(String hno) {
//		this.hno = hno;
//	}
//	public String getFno() {
//		return fno;
//	}
//	public void setFno(String fno) {
//		this.fno = fno;
//	}
//	public String getProfile() {
//		return profile;
//	}
//	public void setProfile(String profile) {
//		this.profile = profile;
//	}
//	public int getUserId() {
//		return userId;
//	}
//	public void setUserId(int userId) {
//		this.userId = userId;
//	}
//	public int getStartRowNum() {
//		return startRowNum;
//	}
//	public void setStartRowNum(int startRowNum) {
//		this.startRowNum = startRowNum;
//	}
//	public int getEndRowNum() {
//		return endRowNum;
//	}
//	public void setEndRowNum(int endRowNum) {
//		this.endRowNum = endRowNum;
//	}
//	public int getRowCount() {
//		return rowCount;
//	}
//	public void setRowCount(int rowCount) {
//		this.rowCount = rowCount;
//	}
//	
//	
	
	
	
}
