package com.multi.instagram.member;

import java.util.List;

public interface MemberService {
	public int signup(MemberDTO member);
	public MemberDTO login(MemberDTO member);
	public int update(MemberDTO member);
	public int delete(MemberDTO member);
	public List<MemberDTO> member_list();
	public MemberDTO read(String member_id);
	//유세희 - 추가 member_id를 비교해서 nickname을 가져오기 위한 작업
	public String member_nick(String member_id);

}
