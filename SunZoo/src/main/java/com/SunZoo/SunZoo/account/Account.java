package com.SunZoo.SunZoo.account;

import org.springframework.stereotype.Component;

@Component
public class Account {
	private static long ACCOUNT_ID;
	private long id ;
	private String account;
	private String pwd;
	
	//Constructor
	//getters
	//toString
	//no arg constructor
	public Account() {
		
	};
	
	public Account(String account, String pwd) {
		super();
//		this.id = id;
		this.account = account;
		this.pwd = pwd;
		ACCOUNT_ID++;
		this.id = ACCOUNT_ID;
	}

	public long getId() {
		return id;
	}


	public String getAccount() {
		return account;
	}


	public String getPwd() {
		return pwd;
	}
	


	public void setId(long id) {
		this.id = id;
	}

	public void setAccount(String account) {
		this.account = account;
	}

	public void setPwd(String pwd) {
		this.pwd = pwd;
	}

	@Override
	public String toString() {
		return "Account [ id =" + id + " account=" + account + ", pwd=" + pwd + "]";
	}
	
	

	
}
