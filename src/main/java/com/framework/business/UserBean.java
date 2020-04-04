package com.framework.business;

import java.util.List;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;
import org.springframework.stereotype.Service;
import com.framework.jpa.*;

//@Service
@Component
public class UserBean {
	@Autowired
	public UserRepository userRepository;
	public UsersEntity user;

	public String Auth(String userid, String pwd) {
		
		try {
			List<UsersEntity> users = userRepository.findByUidAndPwd(userid, pwd);
			if (users.size() > 0) {
				//System.out.println(userid + " " + pwd);
				user = users.get(0);
				return "success";
			} else
				return "error";

		} catch (Exception e) {
			e.printStackTrace();
			return "badrequest400";
		}

	}

	public String Register(String uid, String pwd, String fname, String lname, String address) {
		try {
			List<UsersEntity> users = userRepository.findByUid(uid);
			if (users.size() == 0) {
				UsersEntity usersEntity = new UsersEntity(uid, pwd, fname,lname, address);
				userRepository.save(usersEntity);
				return "success";
			}else {
				return "error";
			}
		} catch (Exception e) {
			e.printStackTrace();
			return "badrequest400";
		}
	}
	
	public String Destroy(String uid, String pwd) {
		try {
			List<UsersEntity> users = userRepository.findByUidAndPwd(uid, pwd);
			if ((users.size() > 0) && (Auth(uid,pwd)=="success")) {
				for(UsersEntity usersEntity:users) {
					userRepository.delete(usersEntity);	
				}	
				return "success";
			}else {
				return "error";
			}
		} catch (Exception e) {
			e.printStackTrace();
			return "badrequest400";
		}
	}

	public String Update(String uid,String currentpwd, String pwd, String fname, String address) {
		try {
			List<UsersEntity> users = userRepository.findByUid(uid);
			//UsersEntity newUsersEntity = new UsersEntity(uid, pwd, fname, address);
			if ((users.size() > 0) && (Auth(uid,currentpwd)=="success")) {
				// set password
				if(pwd!=""&&pwd!=null)
					users.get(0).setPwd(pwd);
				else
					users.get(0).setPwd(users.get(0).getPwd());
				// set user name
				if(fname!=""&&fname!=null)
					users.get(0).setFirstName(fname);
				else
					users.get(0).setFirstName(users.get(0).getFirstName());
				//set address
				if(address!=""&&address!=null)
					users.get(0).setAddress(address);
				else
					users.get(0).setAddress(users.get(0).getAddress());
				
				// save
				userRepository.save(users.get(0));
				return "success";
			}else {
				return "error";
			}
		} catch (Exception e) {
			e.printStackTrace();
			return "badrequest400";
		}
	}

	
}
