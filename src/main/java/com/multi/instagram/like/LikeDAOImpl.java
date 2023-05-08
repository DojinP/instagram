package com.multi.instagram.like;

import java.sql.Date;
import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.jdbc.core.JdbcTemplate;
import org.springframework.stereotype.Repository;

import com.multi.instagram.board.BoardDTO;
import com.multi.instagram.board.BoardFileDTO;
import com.multi.instagram.board.BoardFileRowMapper;
import com.multi.instagram.board.BoardRowMapper;
import com.multi.instagram.member.MemberDTO;


@Repository("LikeDAO")
public class LikeDAOImpl implements LikeDAO{

	@Autowired
	JdbcTemplate template;


	@Override
	public int delete(String likeId) {
		
		return template.update("delete from like_table where likeId=?",likeId);
	}

	@Override
	public List<LikeDTO> read(String likeId, String boardId) {
		
		return template.query("select count(*) from like_table where board_id=?",
				new Object[] {boardId}, new LikeRowMapper());
	}
	@Override
	public List<BoardDTO> like_List(int userId) {
		return template.query("select * from board_table where board_id in (select board_id from like_table where user_id = ?);",
				new Object[] {userId}, new BoardRowMapper());
	}


	@Override
	public int count(String likeId) {
		int cnt = template.queryForObject("select count(*) from like_table where user_id=?",
				Integer.class);
				
		return cnt;
	}
	@Override
	public List<LikeDTO> select_like(int boardId, int userId) {
		return template.query("select * from like_table where board_id=? AND user_id=?",
				new Object[] {boardId,userId}, new LikeRowMapper());
	}
	@Override
	public int insert_like(int boardId, int userId) {
		String sql = "insert into like_table values (null, ?, null, ?, sysdate())";
		return template.update(sql, boardId, userId);
	}

	//추가
	@Override
	public List<BoardFileDTO> select_like_board(int userId) {
		String sql = "select c.* from content_table c, like_table l where c.board_id = l.board_id and l.user_id = ?";
		return template.query(sql, new Object[] {userId}, new BoardFileRowMapper());
	}

	//추가
    @Override
    public List<LikeDTO> select_like_user(int userId) {
        String sql = "select board_id,user_id from like_table where user_id=?";
        return template.query(sql, new Object[] {userId}, new LikeRowMapper());
    }
	

}
