package com.multi.instagram.member;

public class MemberDTO {
	private String id;
	private String pass;
	private String nickname;
	private String name;
	private String gender;
	private String birthday;
	private String email;
	private String tel;
	private String website;
	private String introduction;
	private String timestamp;

	public MemberDTO() {

	}
	
	public MemberDTO(String pass, String email) {
		super();
		this.pass = pass;
		this.email = email;
	}

	public MemberDTO(String pass, String nickname, String name, String email) {
		super();
		this.pass = pass;
		this.nickname = nickname;
		this.name = name;
		this.email = email;
	}

	public MemberDTO(String id, String pass, String nickname, String name, String gender, String birthday, String email,
			String tel, String website, String introduction, String timestamp) {
		super();
		this.id = id;
		this.pass = pass;
		this.nickname = nickname;
		this.name = name;
		this.gender = gender;
		this.birthday = birthday;
		this.email = email;
		this.tel = tel;
		this.website = website;
		this.introduction = introduction;
		this.timestamp = timestamp;
	}

	@Override
	public String toString() {
		return "MemberDTO [id=" + id + ", pass=" + pass + ", nickname=" + nickname + ", name=" + name + ", gender="
				+ gender + ", birthday=" + birthday + ", email=" + email + ", tel=" + tel + ", website=" + website
				+ ", introduction=" + introduction + ", timestamp=" + timestamp + "]";
	}

	public String getId() {
		return id;
	}

	public String getPass() {
		return pass;
	}

	public String getNickname() {
		return nickname;
	}

	public String getName() {
		return name;
	}

	public String getGender() {
		return gender;
	}

	public String getBirthday() {
		return birthday;
	}

	public String getEmail() {
		return email;
	}

	public String getTel() {
		return tel;
	}

	public String getWebsite() {
		return website;
	}

	public String getIntroduction() {
		return introduction;
	}

	public String getTimestamp() {
		return timestamp;
	}

	public void setId(String id) {
		this.id = id;
	}

	public void setPass(String pass) {
		this.pass = pass;
	}

	public void setNickname(String nickname) {
		this.nickname = nickname;
	}

	public void setName(String name) {
		this.name = name;
	}

	public void setGender(String gender) {
		this.gender = gender;
	}

	public void setBirthday(String birthday) {
		this.birthday = birthday;
	}

	public void setEmail(String email) {
		this.email = email;
	}

	public void setTel(String tel) {
		this.tel = tel;
	}

	public void setWebsite(String website) {
		this.website = website;
	}

	public void setIntroduction(String introduction) {
		this.introduction = introduction;
	}

	public void setTimestamp(String timestamp) {
		this.timestamp = timestamp;
	}

}