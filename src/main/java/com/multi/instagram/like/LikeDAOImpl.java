package com.multi.instagram.like;

import java.sql.Date;
import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.jdbc.core.JdbcTemplate;
import org.springframework.stereotype.Repository;

import com.multi.instagram.board.BoardDTO;
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
		return template.query("select * from board_Table where board_id in (select board_id from like_Table where user_id = ?);",
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
		System.out.println("좋아요  - DAO");
		String sql = "insert into like_table values (null, ?, null, ?, sysdate())";
		return template.update(sql, 
				boardId,
				userId
		);
	}
	//JdbcTemplate는 DAO객체에서 DB와 연동하기 위해 SQL 연산들을 수행 할 수 있도록 도와주는 기술
	//1. template.update();
	//   : update()는 SQL 연산을 통해 데이터베이스를 갱신시켜줄 때(INSERT, DELETE, UPDATE) 사용하는 메소드
	//2. temlpate.queryForInt();
	//   : SQL 쿼리를 실행하고 정수의 결과 값(Integer 타입)을 가져올 때 사용하는 메소드
	//		>>내가 사용할 것
	//3. template.queryForObject();
	//   : SQL의 DML 중 SELECT를 실행했을 때 하나의 객체(Object) 결과 값이 나올 때 사용하는 메소드
	//4. template.query();
	//   : queryForInt()가 하나의 결과 값을 위한 메소드인 반면, 많은 결과 값(로우 값)을 처리 할 수 있는 메소드

	
	
	


	

}
