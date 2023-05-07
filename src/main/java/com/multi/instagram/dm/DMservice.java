package com.multi.instagram.dm;

import java.util.List;

import com.multi.instagram.member.MemberDTO;

public interface DMservice {
	public List<DMDTO> select(DMDTO dto);

	public List<MemberDTO> listuser(String member_id);

	public List<DMDTO> boardlist(int user_id);

	public int insert(int sender, int opponent);
}
