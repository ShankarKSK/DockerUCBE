package com.user.module.user.model;

import com.fasterxml.jackson.annotation.JsonIgnoreProperties;
import com.fasterxml.jackson.annotation.JsonInclude;
import com.fasterxml.jackson.annotation.JsonInclude.Include;

@JsonIgnoreProperties(ignoreUnknown = true)
public class UserModel {
	
	String userId = null;
	String userAccountId = null;
	String userName = null;
	
	
	@JsonInclude(Include.NON_NULL)
	AccountModel accountModel = null;
	@JsonInclude(Include.NON_NULL)
	DemoModel demoModel =null;
	
	public AccountModel getAccountModel() {
		return accountModel;
	}

	public void setAccountModel(AccountModel accountModel) {
		this.accountModel = accountModel;
	}

	public DemoModel getDemoModel() {
		return demoModel;
	}

	public void setDemoModel(DemoModel demoModel) {
		this.demoModel = demoModel;
	}

	
	public UserModel() {}
	
	public UserModel(String userId, String userAccountId, String userName) {
		super();
		this.userId = userId;
		this.userAccountId = userAccountId;
		this.userName = userName;
	}
	public String getUserId() {
		return userId;
	}
	public void setUserId(String userId) {
		this.userId = userId;
	}
	public String getUserAccountId() {
		return userAccountId;
	}
	public void setUserAccountId(String userAccountId) {
		this.userAccountId = userAccountId;
	}
	public String getUserName() {
		return userName;
	}
	public void setUserName(String userName) {
		this.userName = userName;
	}

	
}
