package com.user.module.user.controller;

import java.util.ArrayList;

import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import com.user.module.user.model.DemoModel;


@RestController
public class DemoController {
	ArrayList<DemoModel> balanceList = new ArrayList<>();
	
	@RequestMapping("/")
    public ArrayList getAllDetails() {
		balanceList = setAllBalanceDetails();
		return balanceList;
    }
	@RequestMapping(value="/balance/{accountId}")
	public DemoModel getSpecificBalDetails(@PathVariable("accountId") String accountId){
		DemoModel result = null;
		
		if(balanceList == null || balanceList.size()<=0){
			balanceList = setAllBalanceDetails();
		}
		
		for(DemoModel balDeatils :balanceList){
			
			if(accountId.equals(balDeatils.getAccountId())){
				result = new DemoModel();
				result =  balDeatils;
				break;
			}	
			
		}
		 
		return result;
		
	
		
	}

	private ArrayList<DemoModel> setAllBalanceDetails() {
		DemoModel dm1 = new DemoModel("123", "25000", "TAMILNADU");
		DemoModel dm2 = new DemoModel("234", "50000", "KERELA");
		DemoModel dm3 = new DemoModel("345", "100000", "ANDRA");
		
		ArrayList<DemoModel> balList = new ArrayList<>();
		
		balList.add(dm1);
		balList.add(dm2);
		balList.add(dm3);
		return balList;
	}

}
