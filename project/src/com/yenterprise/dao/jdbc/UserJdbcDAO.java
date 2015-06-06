package com.yenterprise.dao.jdbc;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;

import com.yenterprise.dao.UserDAO;
import com.yenterprise.model.UserBean;

public final class UserJdbcDAO extends AbstractBaseJbdcDAO implements UserDAO {
	private static final String UserValidation_SQL = "SELECT firstname, lastname, email, userid, createdate from USER WHERE USERNAME=? AND PASSWORD=?;";
	private final static String INSERT_SQL = "INSERT INTO USER (username, firstname, lastname, email, password, createdate) values (?, ?, ?, ?, ?, ?)";
	private final static String UPDATE_SQL = "UPDATE USER SET firstname=?, lastname=?, email=?, password=? where userid=?;";
	
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
	
	
public UserBean insert(UserBean user) throws Exception{
		
		Connection connection = null;
		PreparedStatement preparedStatement = null;
		ResultSet resultSet = null;
		UserBean loginUser = null;
		
		try{
			connection = getConnection();
			preparedStatement = connection.prepareStatement(INSERT_SQL);
			
			
			preparedStatement.setString(1, user.getUserName());
			preparedStatement.setString(2, user.getFirstName());
			preparedStatement.setString(3, user.getLastName());
			preparedStatement.setString(4, user.getEmail());
			preparedStatement.setString(5, user.getPassword());
			preparedStatement.setTimestamp(6, user.getCreateDate() );	
			
			
			//normally would check to make sure the username existed, but we will just use the login process for now
			preparedStatement.execute();
			
			loginUser= new UserBean();
			loginUser.setUserName(user.getUserName());
			loginUser.setPassword(user.getPassword());

		}finally{
			releaseResources(connection, preparedStatement, resultSet);
		}
		
		

		return login(loginUser);
		
	}

public int update(UserBean user) throws Exception{
	
	Connection connection = null;
	PreparedStatement preparedStatement = null;
	ResultSet resultSet = null;
	int retInt = 0;
	
	try{
		connection = getConnection();
		preparedStatement = connection.prepareStatement(UPDATE_SQL);
		
		
		preparedStatement.setString(1, user.getFirstName());
		preparedStatement.setString(2, user.getLastName());
		preparedStatement.setString(3, user.getEmail());
		preparedStatement.setString(4, user.getPassword());
		preparedStatement.setInt(5, user.getUserId());
		
		
		// should return 1 for an update, if it is zero, it has failed
		retInt = preparedStatement.executeUpdate();
		

	}finally{
		releaseResources(connection, preparedStatement, resultSet);
	}
	
	
	return retInt;
}

}
