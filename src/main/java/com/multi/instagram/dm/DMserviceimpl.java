package com.multi.instagram.dm;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.multi.instagram.member.MemberDTO;

@Service
public class DMserviceimpl implements DMservice {
@Autowired
DMDAO dao;
	@Override
	public List<DMDTO> select(DMDTO dto) {
		return dao.select(dto);
	}
	@Override
	public List<MemberDTO> listuser(String member_id) {
		return dao.listuser(member_id);
	}
	@Override
	public List<DMDTO> boardlist(int user_id) {
		return dao.boardlist(user_id);
	}
	@Override
	public int insert(int sender, int opponent) {
		return dao.insert(sender, opponent);
		
	}	
}
