package com.multi.instagram.board;

import java.sql.Date;
import java.util.List;

import org.springframework.web.multipart.MultipartFile;

import com.multi.instagram.like.LikeDTO;

public class BoardDTO {
	private int boardId;
	private String writerId;
	private String boardContent;
	private Date boardTimestamp;

	// 파일 관련
	private List<MultipartFile> boardfiles;

	// 좋아요 관련
	private int like_count;
	private List<LikeDTO> likeList;

	public List<LikeDTO> getLikeList() {
		return likeList;
	}

	public void setLikeList(List<LikeDTO> likeList) {
		this.likeList = likeList;
	}

	public BoardDTO() {

	}

	// update
	public BoardDTO(int boardId, String boardContent) {
		super();
		this.boardId = boardId;
		this.boardContent = boardContent;
	}

	// insert
	public BoardDTO(String writerId, String boardContent) {
		super();
		this.writerId = writerId;
		this.boardContent = boardContent;
	}

	public BoardDTO(String boardContent, List<MultipartFile> boardfiles) {
		super();
		this.boardContent = boardContent;
		this.boardfiles = boardfiles;
	}

	public BoardDTO(String writerId, String boardContent, List<MultipartFile> boardfiles) {
		super();
		this.writerId = writerId;
		this.boardContent = boardContent;
		this.boardfiles = boardfiles;
	}

	// select
	public BoardDTO(int boardId, String writerId, String boardContent, Date boardTimestamp) {
		super();
		this.boardId = boardId;
		this.writerId = writerId;
		this.boardContent = boardContent;
		this.boardTimestamp = boardTimestamp;
	}

	// select
	public BoardDTO(int boardId, String writerId, String boardContent, Date boardTimestamp,
			List<MultipartFile> boardfiles) {
		super();
		this.boardId = boardId;
		this.writerId = writerId;
		this.boardContent = boardContent;
		this.boardTimestamp = boardTimestamp;
		this.boardfiles = boardfiles;
	}

	// select
	// 김혜원 수정
	public BoardDTO(int boardId, String writerId, String boardContent, Date boardTimestamp, int like_count) {
		super();
		this.boardId = boardId;
		this.writerId = writerId;
		this.boardContent = boardContent;
		this.boardTimestamp = boardTimestamp;
		this.like_count = like_count;
	}

	// select
	// 김혜원 수정
	public BoardDTO(int boardId, String writerId, String boardContent, Date boardTimestamp,
			List<MultipartFile> boardfiles, int like_count) {
		super();
		this.boardId = boardId;
		this.writerId = writerId;
		this.boardContent = boardContent;
		this.boardTimestamp = boardTimestamp;
		this.boardfiles = boardfiles;
		this.like_count = like_count;
	}

	@Override
	public String toString() {
		return "BoardDTO [boardId=" + boardId + ", writerId=" + writerId + ", boardContent=" + boardContent
				+ ", boardTimestamp=" + boardTimestamp + ", boardfiles=" + boardfiles + "]";
	}

	// getter & setter
	public int getBoardId() {
		return boardId;
	}

	// getter setter likecount 추가
	public int getLike_count() {
		return like_count;
	}

	public void setLike_count(int like_count) {
		this.like_count = like_count;
	}

	public List<MultipartFile> getBoardfiles() {
		return boardfiles;
	}

	public void setBoardfiles(List<MultipartFile> boardfiles) {
		this.boardfiles = boardfiles;
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
