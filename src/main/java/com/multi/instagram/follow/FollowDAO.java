package com.multi.instagram.follow;

import java.util.List;

import com.multi.instagram.member.MemberDTO;



public interface FollowDAO {
	int getFollowCount(String follower_id);
	int getFollowerCount(String following_id);
	List<FollowDTO> getFollowList(String follower_id);
	List<FollowDTO> getFollowerList(String following_id);
	MemberDTO getMember(String member_id);
	public int connectFollow(String follow_Id, String follower_Id);
	public int disconnectFollow(String follow_id);
	FollowDTO getFollowAsMember(String follower_id, String following_id);
}
