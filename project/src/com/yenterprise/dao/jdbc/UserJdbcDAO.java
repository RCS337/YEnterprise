package com.yenterprise.dao.jdbc;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;

import com.yenterprise.dao.UserDAO;
import com.yenterprise.model.UserBean;

public final class UserJdbcDAO extends AbstractBaseJbdcDAO implements UserDAO {
	private static final String UserValidation_SQL = "SELECT firstname, lastname, email, userid, createdate from USER WHERE USERNAME=? AND PASSWORD=?;";
	
	@Override
	public UserBean login(UserBean user) throws Exception {
		Connection connection = null;
		PreparedStatement preparedStatement = null;
		ResultSet resultSet = null;
		
		try{
			connection = getConnection();
			preparedStatement = connection.prepareStatement(UserValidation_SQL);
			
			
			preparedStatement.setString(1, user.getUserName());
			preparedStatement.setString(2, user.getPassword());
			
			resultSet = preparedStatement.executeQuery();
			if(resultSet.next()){
				user.setFirstName(resultSet.getString("firstname"));
				user.setLastName(resultSet.getString("lastName"));
				user.setEmail(resultSet.getString("email"));
				user.setUserId(resultSet.getInt("userid"));
				user.setCreateDate(resultSet.getTimestamp("createdate"));
				
				//blank out the password so it is not stored in the session
				user.setPassword(null);
			}else{
				user=null;
			}

		
		}finally{
			releaseResources(connection, preparedStatement, resultSet);
			
		}
		
		return user;
		
	}

}
