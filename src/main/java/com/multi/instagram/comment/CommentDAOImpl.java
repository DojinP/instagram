package com.multi.instagram.comment;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.jdbc.core.JdbcTemplate;
import org.springframework.stereotype.Repository;

@Repository
public class CommentDAOImpl implements CommentDAO {
	@Autowired
	JdbcTemplate template;
	
	@Override
	public List<CommentDTO> selectAll(String board_id) {
		String sql = "select * from comment_table where board_id=?";
		return template.query(sql, new Object[] {board_id}, new CommentRowMapper());
	}

	@Override
	public int insert(CommentDTO comment) {
		String sql = "insert into comment_table values(null, ?, ?, ?, sysdate())";
		return template.update(sql, comment.getBoard_id(),
				                    comment.getUser_id(),
				                    comment.getContent());
	}

	@Override
	public int delete(String comment_id) {
		String sql = "delete from comment_table where comment_id=?";
		return template.update(sql, comment_id);
	}

	@Override
	public int update(CommentDTO comment) {
		String sql = "update comment_table set comment_content=? where comment_id=?";
		return template.update(sql, comment.getContent(), comment.getComment_id());
	}

	@Override
	public CommentDTO read(String board_id, String user_id) {
		String sql = "select * from comment_table where board_id=? and user_id=?";
		return template.queryForObject(sql, new Object[] {board_id, user_id}, new CommentRowMapper());
	}

}
