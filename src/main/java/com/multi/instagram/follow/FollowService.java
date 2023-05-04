package com.multi.instagram.follow;

import java.util.List;

import com.multi.instagram.member.MemberDTO;


public interface FollowService {
	int getFollowCount(String follower_id);
	int getFollowerCount(String following_id);
	List<FollowDTO> getFollowList(String following_id);
	List<FollowDTO> getFollowerList(String follower_id);
	public int connectFollow(String follower_id, String following_id);
	public int disconnectFollow(String follow_id);
	MemberDTO getMember(String member_id);
	FollowDTO getFollowAsMember(String loginId, String member_id);

}
