package com.multi.instagram.member;

import java.util.List;

public interface MemberDAO {
	public int signup(MemberDTO member);
	public MemberDTO login(MemberDTO member);
	public int update(MemberDTO member);
	public int delete(MemberDTO member);
	public List<MemberDTO> member_list();
	public MemberDTO read(String member_id);
	//유세희 - 추가 (닉네임받기)
	public String member_nick(String member_id);
}
