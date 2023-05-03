package com.multi.instagram.comment;

public class CommentDTO {
	private String comment_id;
	private String board_id;
	private String user_id;
	private String content;
	private String timestamp;
	
	public CommentDTO() {
		// TODO Auto-generated constructor stub
	}
	
	public CommentDTO(String comment_id, String board_id, String user_id, String content, String timestamp) {
		super();
		this.comment_id = comment_id;
		this.board_id = board_id;
		this.user_id = user_id;
		this.content = content;
		this.timestamp = timestamp;
	}

	@Override
	public String toString() {
		return "CommentDTO [comment_id=" + comment_id + ", board_id=" + board_id + ", user_id=" + user_id + ", content="
				+ content + ", timestamp=" + timestamp + "]";
	}

	public String getComment_id() {
		return comment_id;
	}

	public void setComment_id(String comment_id) {
		this.comment_id = comment_id;
	}

	public String getBoard_id() {
		return board_id;
	}

	public void setBoard_id(String board_id) {
		this.board_id = board_id;
	}

	public String getUser_id() {
		return user_id;
	}

	public void setUser_id(String user_id) {
		this.user_id = user_id;
	}

	public String getContent() {
		return content;
	}

	public void setContent(String content) {
		this.content = content;
	}

	public String getTimestamp() {
		return timestamp;
	}

	public void setTimestamp(String timestamp) {
		this.timestamp = timestamp;
	}
	
}
