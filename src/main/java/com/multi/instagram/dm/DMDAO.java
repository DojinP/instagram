package com.multi.instagram.dm;

import java.util.List;

import com.multi.instagram.member.MemberDTO;

public interface DMDAO {

	List<DMDTO> select(DMDTO dto);

	List<MemberDTO> listuser(String member_id);

	List<DMDTO> boardlist(int user_id);

	int insert(int sender, int opponent);

}
