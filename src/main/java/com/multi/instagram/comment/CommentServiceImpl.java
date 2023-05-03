package com.multi.instagram.comment;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

@Service
public class CommentServiceImpl implements CommentService {
	@Autowired
	CommentDAO dao;
	
	@Override
	public List<CommentDTO> selectAll(String board_id) {
		return dao.selectAll(board_id);
	}

	@Override
	public int insert(CommentDTO comment) {
		return dao.insert(comment);
	}

	@Override
	public int delete(String comment_id) {
		return dao.delete(comment_id);
	}

	@Override
	public int update(CommentDTO comment) {
		return dao.update(comment);
	}

	@Override
	public CommentDTO read(String board_id, String user_id) {
		return dao.read(board_id, user_id);
	}

}
