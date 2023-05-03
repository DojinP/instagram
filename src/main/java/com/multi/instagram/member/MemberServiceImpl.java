package com.multi.instagram.member;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

@Service
public class MemberServiceImpl implements MemberService {
	@Autowired
	MemberDAO dao;
	
	@Override
	public int signup(MemberDTO member) {
		System.out.println("회원가입 시행 - Service");
		return dao.signup(member);
	}
	
	@Override
	public MemberDTO login(MemberDTO member) {
		System.out.println("로그인 시행 - Service");
		return dao.login(member);
	}
	
}
