package com.framework.jpa;

import java.util.List;

import org.springframework.data.jpa.repository.*;
import org.springframework.data.repository.CrudRepository;
import org.springframework.stereotype.Repository;
import org.springframework.transaction.annotation.Transactional;
import com.framework.jpa.UsersEntity;

@Repository
public interface UserRepository extends JpaRepository<UsersEntity, String>  {
	 @Query("SELECT u FROM UsersEntity u WHERE u.uid=?1 and u.pwd=?2")
	 public List<UsersEntity> findByUidAndPwd(String users,String password);
	 @Query("SELECT u FROM UsersEntity u WHERE u.uid=?1")
	 public List<UsersEntity> findByUid(String users);

	 
}
