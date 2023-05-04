package com.multi.instagram.board;

public class BoardFileDTO {
	private int boardId;
	private String originalFilename;
	private String storeFilename;
	private String boardImageFileno;
	public BoardFileDTO() {
		
	}


	public BoardFileDTO(String originalFilename, String storeFilename) {
		super();
		this.originalFilename = originalFilename;
		this.storeFilename = storeFilename;
	}

	
	

	public BoardFileDTO(int boardId, String storeFilename, String boardImageFileno) {
		super();
		this.boardId = boardId;
		this.storeFilename = storeFilename;
		this.boardImageFileno = boardImageFileno;
	}


	public BoardFileDTO(int boardId, String originalFilename, String storeFilename, String boardImageFileno) {
		super();
		this.boardId = boardId;
		this.originalFilename = originalFilename;
		this.storeFilename = storeFilename;
		this.boardImageFileno = boardImageFileno;
	}

	@Override
	public String toString() {
		return "BoardFileDTO [boardId=" + boardId + ", originalFilename=" + originalFilename + ", storeFilename="
				+ storeFilename + ", boardImageFileno=" + boardImageFileno + "]";
	}

	public int getBoardId() {
		return boardId;
	}

	public void setBoardId(int boardId) {
		this.boardId = boardId;
	}

	public String getOriginalFilename() {
		return originalFilename;
	}

	public void setOriginalFilename(String originalFilename) {
		this.originalFilename = originalFilename;
	}

	public String getStoreFilename() {
		return storeFilename;
	}

	public void setStoreFilename(String storeFilename) {
		this.storeFilename = storeFilename;
	}

	public String getBoardImageFileno() {
		return boardImageFileno;
	}

	public void setBoardImageFileno(String boardImageFileno) {
		this.boardImageFileno = boardImageFileno;
	}
	
	
	
	
}
