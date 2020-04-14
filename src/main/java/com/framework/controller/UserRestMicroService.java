package com.framework.controller;

import com.framework.business.*;
import com.framework.jpa.*;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

@RestController
public class UserRestMicroService {
	@Autowired
	UserBean userBean;
	
	
	@GetMapping(value="/checkuser/{uid}")
	public String Checkuser(@PathVariable String uid) {
		String result = userBean.Checkuser(uid);
		if (result.equals("success")) {
			return "success";
		} else {
			return "error";
		}
		
	}
		
	@GetMapping(value="/checkpwd/{uid}")
	public String Checkpwd(@PathVariable String uid) {
		String pwd = userBean.Checkpwd(uid);
		if(pwd.equals("error")) {
			return "error";
		}else {
			return pwd;
		}
	}
	
	@GetMapping(value="/authRest/{uid}/{pwd}")
	public String login(@PathVariable String uid, @PathVariable String pwd) {
		String ue = userBean.Auth(uid, pwd);
		if(ue.equals("success")) {
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
		if(ue.equals("success")) {
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
		if(ue.equals("success")) {
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
		if(ue.equals("success")) {
			//System.out.println("success");
			return "success";
		}else {
			//System.out.println("error");
			return "error";
		}
	}

}
