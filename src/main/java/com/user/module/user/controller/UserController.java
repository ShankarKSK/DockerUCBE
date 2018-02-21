package com.user.module.user.controller;


import java.util.ArrayList;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.CrossOrigin;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RestController;
import org.springframework.web.client.RestTemplate;

import com.user.module.user.model.AccountModel;
import com.user.module.user.model.DemoModel;
import com.user.module.user.model.UserModel;


@RestController
@CrossOrigin(origins = "*")
public class UserController {
	
	@Autowired
	private RestTemplate restTemplate;
	
	

	ArrayList<UserModel> userList = new ArrayList<>();
	@RequestMapping(value="/users" ,method=RequestMethod.GET,produces="application/json")
	public ArrayList<UserModel> getAllAccounts(){
		
		if(userList == null || userList.size()<=0){
			userList = getUsers();
		}
		return userList;
		
	}
	/*@RequestMapping(value="/alluserdetails/{userid}")
	public UserModel getAllUserDetails(@PathVariable("userid") String userid ){
		UserModel userModel = getSpecificUser(userid);
		AccountModel accModel = restTemplate.getForObject("http://localhost:8086/account/{accountid}", AccountModel.class,userModel.getUserAccountId());
		DemoModel demoModel = restTemplate.getForObject("http://localhost:8084/balance/{accountid}", DemoModel.class, userModel.getUserAccountId());
		
		
		userModel.setAccountModel(accModel);
		userModel.setDemoModel(demoModel);
		
		return userModel;
	}*/
	
	@RequestMapping(value="/user/{userid}" ,method=RequestMethod.DELETE)
	public ResponseEntity  deleteUserOptions(@PathVariable("userid") String userid){
		
		if(userid != null){
			if(userList == null || userList.size()<=0){
				userList = getUsers();
			}
			
			for(UserModel user : userList){
				if(user.getUserId().equals(userid)){
					userList.remove(user);
					
				}
			}
		}
		
		return ResponseEntity.status(HttpStatus.CREATED).build();
		
	}
	@RequestMapping(value="/user" ,method=RequestMethod.POST)
	public ResponseEntity  addUser(@RequestBody UserModel person){
		
		if(person.getUserAccountId() != null){
			if(userList == null || userList.size()<=0){
				userList = getUsers();
			}
			int x= userList.size()+1;
			String id = "0"+x;
			userList.add(new UserModel(id, person.getUserAccountId(), person.getUserName()));
			System.out.println(userList);
			 return ResponseEntity.status(HttpStatus.CREATED).build();
		}
		 return ResponseEntity.status(HttpStatus.CREATED).build();
		
	}
	
	@RequestMapping(value="/user/{userid}",method=RequestMethod.GET)
	public UserModel getSpecificUser(@PathVariable("userid") String userid ){
		UserModel result = null;
		
		if(userList == null || userList.size()<=0){
			userList = getUsers();
		}
		
		for(UserModel userDeatils :userList){
			
			if(userid.equals(userDeatils.getUserId())){
				result = new UserModel();
				result =  userDeatils;
				break;
			}	
			
		}
		 
		return result;
		
	}
	
	

	private ArrayList<UserModel> getUsers() {
		UserModel um1 = new UserModel("01","123","SHANKAR");
		UserModel um2 = new UserModel("02","234","VISHWA");
		UserModel um3 = new UserModel("03","345","NARESH");
		
		
		ArrayList<UserModel> accountList = new ArrayList<>();
		
		accountList.add(um1);
		accountList.add(um2);
		accountList.add(um3);
		
		return accountList;
	}



}
