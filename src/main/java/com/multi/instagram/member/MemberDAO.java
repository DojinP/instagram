package com.multi.instagram.member;

public interface MemberDAO {
	public int signup(MemberDTO member);
	public MemberDTO login(MemberDTO member);
}
