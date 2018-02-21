package com.user.module.user.model;

import com.fasterxml.jackson.annotation.JsonIgnoreProperties;

@JsonIgnoreProperties(ignoreUnknown = true)
public class DemoModel {
	
	String accountId = null;
	String balance = null;
	String state = null;
	
	public DemoModel() {
		
	}
	public DemoModel(String accountId, String balance, String state) {
		super();
		this.accountId = accountId;
		this.balance = balance;
		this.state = state;
	}
	public String getAccountId() {
		return accountId;
	}
	public void setAccountId(String accountId) {
		this.accountId = accountId;
	}
	public String getBalance() {
		return balance;
	}
	public void setBalance(String balance) {
		this.balance = balance;
	}
	public String getState() {
		return state;
	}
	public void setState(String state) {
		this.state = state;
	}
	

}
