package com.multi.instagram.member;

public interface MemberService {
	public int signup(MemberDTO member);
	public MemberDTO login(MemberDTO member);
}
