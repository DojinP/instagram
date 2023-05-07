package com.multi.instagram.follow;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.jdbc.core.JdbcTemplate;
import org.springframework.stereotype.Repository;

import com.multi.instagram.board.BoardFileDTO;
import com.multi.instagram.board.BoardFileRowMapper;
import com.multi.instagram.member.MemberDTO;
import com.multi.instagram.member.MemberRowMapper;

@Repository
public class FollowDAOImpl implements FollowDAO {
	@Autowired
	JdbcTemplate template;

	@Override
	public int getFollowCount(String follower_id) {
		String sql = "select count(follower_id) from follow_table where following_id =?";
		int followCount = template.queryForObject(sql, Integer.class, follower_id);
		return followCount;
	}

	@Override
	public int getFollowerCount(String following_id) {
		String sql = "select count(following_id) from follow_table where follower_id =?";
		int followerCount = template.queryForObject(sql, Integer.class, following_id);
		return followerCount;
	}

	@Override
	public List<FollowDTO> getFollowList(String follower_id) {
		String sql = "select * from follow_table where follower_id = ?";
		return template.query(sql, new Object[] { follower_id }, new FollowRowMapper());
	}

	@Override
	public List<FollowDTO> getFollowerList(String following_id) {
		String sql = "select * from follow_table where following_id = ?";
		return template.query(sql, new Object[] { following_id }, new FollowRowMapper());
	}

	@Override
	public int connectFollow(String follower_id, String following_id) {
		String sql = "insert into follow_table values(null,?,?)";
		return template.update(sql, following_id, follower_id);
	}

	@Override
	public FollowDTO getFollowAsMember(String follower_id, String following_id) {
		String sql = "select a.follow_id, a.following_id, a.follower_id from (select follow_id, following_id, follower_id from follow_table where follower_id = ?) a where a.following_id = ?";
		return template.queryForObject(sql, new Object[] { follower_id, following_id }, new FollowRowMapper());
	}

	@Override
	public int disconnectFollow(String follow_id) {
		return template.update("delete from follow_table where follow_id=?", follow_id);

	}

	@Override
	public MemberDTO getMember(String member_id) {
		String sql = " select * from member_table where member_id = ?";
		return template.queryForObject(sql, new Object[] { member_id }, new MemberRowMapper());
	}
	
	@Override
	public List<BoardFileDTO> getMyData(int writer_id) {
		String sql = "SELECT c.* from content_table c JOIN board_table b ON c.board_id = b.board_id WHERE b.writer_id = ?";
		
		return template.query(sql, new Object[] { writer_id }, new BoardFileRowMapper());
	}
}