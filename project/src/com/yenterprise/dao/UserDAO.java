package com.yenterprise.dao;

import com.yenterprise.model.UserBean;

public interface UserDAO  {
	
	public UserBean insert(UserBean user) throws Exception;
	
	public UserBean login(UserBean user) throws Exception;
	
	public int update(UserBean user) throws Exception;
	

}
