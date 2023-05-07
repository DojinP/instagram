package com.multi.instagram.dm;

import java.sql.Date;

public class dm_chatroomDTO {
	private int message_id;
	private int dm_id;
	private String sender_id;
	private String message_content;
	private Date message_timestamp;
	
	
	public dm_chatroomDTO(int message_id, int dm_id, String sender_id, String message_content, Date message_timestamp) {
		this.message_id = message_id;
		this.dm_id = dm_id;
		this.sender_id = sender_id;
		this.message_content = message_content;
		this.message_timestamp = message_timestamp;
	}
	public int getMessage_id() {
		return message_id;
	}
	public void setMessage_id(int message_id) {
		this.message_id = message_id;
	}
	public int getDm_id() {
		return dm_id;
	}
	public void setDm_id(int dm_id) {
		this.dm_id = dm_id;
	}
	public String getSender_id() {
		return sender_id;
	}
	public void setSender_id(String sender_id) {
		this.sender_id = sender_id;
	}
	public String getMessage_content() {
		return message_content;
	}
	public void setMessage_content(String message_content) {
		this.message_content = message_content;
	}
	public Date getMessage_timestamp() {
		return message_timestamp;
	}
	public void setMessage_timestamp(Date message_timestamp) {
		this.message_timestamp = message_timestamp;
	}
	
}
