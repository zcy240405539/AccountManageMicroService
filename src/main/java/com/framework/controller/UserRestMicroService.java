package com.framework.controller;

import com.framework.business.*;
import com.framework.jpa.*;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

@RestController
public class UserRestMicroService {
	@Autowired
	UserBean userBean;
	
	@GetMapping(value="/authRest/{uid}/{pwd}")
	public String login(@PathVariable String uid, @PathVariable String pwd) {
		String ue = userBean.Auth(uid, pwd);
		if(ue == "success") {
			//System.out.println("success");
			return "success";
		}else {
			//System.out.println("error");
			return "error";
		}
	}
	
	@GetMapping(value="/registRest/{uid}/{pwd}/{fname}/{lname}/{address}")
	public String register(@PathVariable String uid, @PathVariable String pwd, @PathVariable String fname, @PathVariable String lname, @PathVariable String address) {
		String ue = userBean.Register(uid, pwd, fname, lname, address);
		if(ue == "success") {
			//System.out.println("success");
			return "success";
		}else {
			//System.out.println("error");
			return "error";
		}
	}
	
	@GetMapping(value="/destroyRest/{uid}/{pwd}")
	public String destroy(@PathVariable String uid, @PathVariable String pwd) {
		String ue = userBean.Destroy(uid, pwd);
		if(ue == "success") {
			//System.out.println("success");
			return "success";
		}else {
			//System.out.println("error");
			return "error";
		}
	}	
	
	@GetMapping(value="/updateRest/{uid}/{pwd}/{fname}/{lname}/{address}")
	public String update(@PathVariable String uid, @PathVariable String pwd, @PathVariable String fname, @PathVariable String lname, @PathVariable String address) {
		String ue = userBean.Update(uid, pwd, fname, lname, address);
		if(ue == "success") {
			//System.out.println("success");
			return "success";
		}else {
			//System.out.println("error");
			return "error";
		}
	}

}
