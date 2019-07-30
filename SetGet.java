package com.login.Controller;

public class SetGet {
	private String id;
	private String name;
	private String  mail;
	private String mobile;
	public String getId() {
		System.out.println("Id send");
		return id;
		
	}
	public void setId(String id) {
		this.id = id;
		System.out.println("Id insert");
	}
	public String getName() {
		return name;
	}
	public void setName(String name) {
		this.name = name;
	}
	public String getMail() {
		return mail;
	}
	public void setMail(String mail) {
		this.mail = mail;
	}
	public String getMobile() {
		return mobile;
	}
	public void setMobile(String mobile) {
		this.mobile = mobile;
	}

}
