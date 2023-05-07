package com.multi.instagram.dm;

public class DMDTO {
	private int dm_id;
	private String sender_id; //유저
	private String receiver_id; //받는 유저

	public DMDTO() {

	}

	public DMDTO(int dm_id, String sender_id, String receiver_id) {
		this.dm_id = dm_id;
		this.sender_id = sender_id;
		this.receiver_id = receiver_id;
	}
	

	
	public DMDTO(String sender_id, String receiver_id) {
		this.sender_id = sender_id;
		this.receiver_id = receiver_id;
	}
	
	
	public DMDTO(String receiver_id) {
		super();
		this.receiver_id = receiver_id;
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

	public String getReceiver_id() {
		return receiver_id;
	}

	public void setReceiver_id(String receiver_id) {
		this.receiver_id = receiver_id;
	}

}
