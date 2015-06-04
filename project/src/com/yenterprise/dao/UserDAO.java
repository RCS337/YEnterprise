package com.yenterprise.dao;

import com.yenterprise.model.UserBean;

public interface UserDAO  {
	
	//public void insert(UserBean user) throws Exception;
	
	public UserBean login(UserBean user) throws Exception;
	

}
