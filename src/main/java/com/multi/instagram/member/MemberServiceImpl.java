package com.multi.instagram.member;

import java.util.List;

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
	
	@Override
	public int update(MemberDTO member) {
		System.out.println("업데이트 시행 - Service");
		return dao.update(member);
	}
	
	@Override
	public int delete(MemberDTO member) {
		return dao.delete(member);
	}
	
	// Board 관련
	@Override
	public List<MemberDTO> member_list() {
		return dao.member_list();
	}

	
	// Follow 관련
	@Override
	public MemberDTO read(String member_id) {
		return dao.read(member_id);
	}
	
	//유세희 - 추가 member_id를 비교해서 nickname을 가져오기 위한 작업
	@Override
	public String member_nick(String member_id) {
		return dao.member_nick(member_id);
	}
}
