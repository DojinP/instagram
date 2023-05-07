package com.multi.instagram.dm;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

@Service
public class dm_chatroomServiceimpl implements dm_chatroomService {
	@Autowired
	dm_chatroomDAO chatdao;

	@Override
	public int insert(int dmId, String sender, String content) {
		return chatdao.insert(dmId, sender, content);
	}

	@Override
	public List<dm_chatroomDTO> listchat(int dmid) {
		return chatdao.List(dmid);
	}

}
	