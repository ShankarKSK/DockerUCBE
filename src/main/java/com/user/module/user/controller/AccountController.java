package com.user.module.user.controller;

import java.util.ArrayList;



import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;

import org.springframework.web.bind.annotation.RestController;

import com.user.module.user.model.AccountModel;



@RestController
public class AccountController {
	ArrayList<AccountModel> accountList = new ArrayList<>();
	@RequestMapping(value="/account")
	public ArrayList<AccountModel> getAllAccounts(){
		
		accountList = getAccounts();
		return accountList;
		
	}
	
	@RequestMapping(value="/account/{accountid}")
	public AccountModel getSpecificAccount(@PathVariable("accountid") String accountid ){
		AccountModel result = null;
		
		if(accountList == null || accountList.size()<=0){
			accountList = getAccounts();
		}
		
		for(AccountModel accDeatils :accountList){
			
			if(accountid.equals(accDeatils.getAccountId())){
				result = new AccountModel();
				result =  accDeatils;
				break;
			}	
			
		}
		 
		return result;
		
	}
	
	

	private ArrayList<AccountModel> getAccounts() {
		AccountModel am1 = new AccountModel();
		
		am1.setAccountId("123");
		
		am1.setAccountType("SAVINGS");
		
		AccountModel am2 = new AccountModel();
		
		am2.setAccountId("234");
		
		am2.setAccountType("SALARY");
		
		AccountModel am3 = new AccountModel();
		
		am3.setAccountId("345");
		
		am3.setAccountType("CURRENT");
		
		ArrayList<AccountModel> accountList = new ArrayList<>();
		
		accountList.add(am1);
		accountList.add(am2);
		accountList.add(am3);
		
		return accountList;
	}

}
