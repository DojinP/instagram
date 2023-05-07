package com.multi.instagram.dm;

import java.util.List;

import org.springframework.stereotype.Repository;

public interface dm_chatroomDAO {

	int insert(int dmId,String sender, String content);

	List<dm_chatroomDTO> List(int dmid);
}
