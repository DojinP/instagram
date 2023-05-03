package com.multi.instagram.comment;

import java.util.List;

public interface CommentDAO {
	// 모든 댓글 조회
	public List<CommentDTO> selectAll(String board_id);
	// 댓글 작성
	public int insert(CommentDTO comment);
	// 댓글 삭제
	public int delete(String comment_id);
	// 댓글 수정
	public int update(CommentDTO comment);
	// 댓글 조회
	public CommentDTO read(String board_id, String user_id);
}
