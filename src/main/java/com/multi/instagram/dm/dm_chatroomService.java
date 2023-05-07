package com.multi.instagram.dm;

import java.util.List;

public interface dm_chatroomService {

	int insert(int dmId,String sender, String content);

	List<dm_chatroomDTO> listchat(int dmid);	
}
