package com.SunZoo.SunZoo.account;

import org.springframework.stereotype.Component;

@Component
public class VisitorAccount {
	private static long ACCOUNT_ID;
	private long id;
	private String account;
	private String pwd;
	private int spentMoney = 0; // Initial balance is zero

	// Constructor
	// getters
	// toString
	// no arg constructor
	public VisitorAccount() {

	};

	public VisitorAccount(String account, String pwd) {
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

	public void increaseSpentAmount(int amount) {
		this.spentMoney += amount;
	}
	

	public int getSpentMoney() {
		return spentMoney;
	}

	@Override
	public String toString() {
		return "Account [ id =" + id + " account=" + account + ", pwd=" + pwd + "]";
	}

}
