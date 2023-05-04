package com.multi.instagram.follow;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.multi.instagram.member.MemberDTO;


@Service
public class FollowServiceImpl implements FollowService {
	@Autowired
	FollowDAO dao;

	@Override
	public int getFollowCount(String follower_id) {
		return dao.getFollowCount(follower_id);
	}

	@Override
	public int getFollowerCount(String following_id) {
		return dao.getFollowerCount(following_id);
	}

	@Override
	public List<FollowDTO> getFollowList(String follower_id) {
		return dao.getFollowList(follower_id);
	}

	@Override
	public List<FollowDTO> getFollowerList(String following_id) {
		return dao.getFollowerList(following_id);
	}

	@Override
	public int connectFollow(String follower_id, String following_id) {
		return dao.connectFollow(follower_id, following_id);
	}

	@Override
	public int disconnectFollow(String follow_id) {
		return dao.disconnectFollow(follow_id);
	}

	@Override
	public MemberDTO getMember(String member_id) {
		return dao.getMember(member_id);
	}

	@Override
	public FollowDTO getFollowAsMember(String loginId, String member_id) {
		return dao.getFollowAsMember(loginId, member_id);
	}

}
