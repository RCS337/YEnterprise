package com.yenterprise.dao.jdbc;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;

public abstract class AbstractBaseJbdcDAO {
	
	private static final String DRIVER_NAME = "com.mysql.jdbc.Driver";
    private static final String DB_URL = "jdbc:mysql://localhost:3306/yenterprises";
    private static final String DB_USER = "root";
    private static final String DB_PASSWORD = "1234";

    /**
     * Returns a connection to the database.
     * @return Database connection
     * @throws SQLException
     */
    final protected Connection getConnection() throws SQLException
    {
        try
        {
            Connection myConnection;
            Class.forName(DRIVER_NAME);
            myConnection = DriverManager.getConnection(DB_URL, DB_USER, DB_PASSWORD);
            return(myConnection);
        }
        catch(ClassNotFoundException cnfe)
        {
            throw new SQLException(cnfe);
        }
    }
    
    final protected void releaseResources(Connection connection, Statement statement, ResultSet resultsSet){
    	
    	try{
    		if (resultsSet != null){
    			resultsSet.close();
    		}
    	}catch (Exception ex){
    		ex.printStackTrace();
    	}
    	
    	try{
    		if (statement != null){
    			statement.close();
    		}
    	}catch (Exception ex){
    		ex.printStackTrace();
    	}
    	
    	try{
    		if (connection != null){
    			connection.close();
    		}
    	}catch (Exception ex){
    		ex.printStackTrace();
    	}
    	
    	
    	
    }

}
