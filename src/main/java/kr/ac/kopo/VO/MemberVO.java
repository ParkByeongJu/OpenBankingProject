package kr.ac.kopo.VO;

import java.util.Date;

public class MemberVO {
	
	private String id;
	private String password;
	private String name;
	private String email;
	private Date birth;
	private String phone;
	private int post;
	private String fullAddr;
	private String extraAddr;
	private String role;
	
	
	public MemberVO(String id, String password, String name, String email, Date birth, String phone, int post,
			String fullAddr, String extraAddr, String role) {
		super();
		this.id = id;
		this.password = password;
		this.name = name;
		this.email = email;
		this.birth = birth;
		this.phone = phone;
		this.post = post;
		this.fullAddr = fullAddr;
		this.extraAddr = extraAddr;
		this.role = role;
	}
	
	public String getId() {
		return id;
	}
	public void setId(String id) {
		this.id = id;
	}
	public String getPassword() {
		return password;
	}
	public void setPassword(String password) {
		this.password = password;
	}
	public String getName() {
		return name;
	}
	public void setName(String name) {
		this.name = name;
	}
	public String getEmail() {
		return email;
	}
	public void setEmail(String email) {
		this.email = email;
	}
	public Date getBirth() {
		return birth;
	}
	public void setBirth(Date birth) {
		this.birth = birth;
	}
	public String getPhone() {
		return phone;
	}
	public void setPhone(String phone) {
		this.phone = phone;
	}
	public int getPost() {
		return post;
	}
	public void setPost(int post) {
		this.post = post;
	}
	public String getFullAddr() {
		return fullAddr;
	}
	public void setFullAddr(String fullAddr) {
		this.fullAddr = fullAddr;
	}
	public String getExtraAddr() {
		return extraAddr;
	}
	public void setExtraAddr(String extraAddr) {
		this.extraAddr = extraAddr;
	}
	public String getRole() {
		return role;
	}
	public void setRole(String role) {
		this.role = role;
	}
	
	
	

}
