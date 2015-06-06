package com.yenterprise.dao.jdbc;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.util.ArrayList;
import java.util.List;

import com.yenterprise.dao.PostDAO;
import com.yenterprise.model.PostBean;

public final class PostJdbcDAO extends AbstractBaseJbdcDAO implements PostDAO {

	private final static String SELECT_SQL_BYID = "Select postId, createdate, createdby, title, shortdesc, longdesc, updatedby, updateddate from post where postId=?;";
	private final static String SELECT_SQL_ALL = "Select postId, createdate, createdby, title, shortdesc, longdesc, updatedby, updateddate from post order by createdate desc;";
	private final static String UPDATE_SQL = "UPDATE POST SET title=?, shortdesc=?, longdesc=?, updatedby=?, updateddate=? where postId=?";
	private final static String INSERT_SQL = "INSERT INTO POST (createdate, createdby, title, shortdesc, longdesc, updatedby, updateddate) values (?, ?, ?, ?, ?, ?, ?)";
	private final static String DELETE_SQL = "DELETE FROM POST WHERE postId=?;";
	
public void insert(PostBean post) throws Exception{
		
		Connection connection = null;
		PreparedStatement preparedStatement = null;
		ResultSet resultSet = null;

		
		try{
			connection = getConnection();
			preparedStatement = connection.prepareStatement(INSERT_SQL);
			
			preparedStatement.setTimestamp(1, post.getCreateDate() );
			preparedStatement.setString(2, post.getCreatedBy());
			preparedStatement.setString(3, post.getTitle());
			preparedStatement.setString(4, post.getShortDesc());
			preparedStatement.setString(5, post.getLongDesc());
			preparedStatement.setString(6, post.getUpdatedBy());
			preparedStatement.setTimestamp(7, post.getUpdateDate() );			
			//preparedStatement.setInt(6, post.getPostId());
			preparedStatement.execute();
			//result = preparedStatement.executeUpdate();

		
		}finally{
			releaseResources(connection, preparedStatement, resultSet);
		}
		//return result;
		
	}

	public PostBean read(int postId) throws Exception {
		PostBean post = new PostBean();
		Connection connection = null;
		PreparedStatement preparedStatement = null;
		ResultSet resultSet = null;
		
		try{
			connection = getConnection();
			preparedStatement = connection.prepareStatement(SELECT_SQL_BYID);
			preparedStatement.setInt(1, postId);
			resultSet = preparedStatement.executeQuery();
			
			while(resultSet.next()){
				post.setPostId(resultSet.getInt("postId"));
				post.setCreateDate(resultSet.getTimestamp("createdate"));
				post.setCreatedBy(resultSet.getString("createdby"));
				post.setTitle(resultSet.getString("title"));
				post.setShortDesc(resultSet.getString("shortdesc"));
				post.setLongDesc(resultSet.getString("longdesc"));
				post.setUpdatedBy(resultSet.getString("updatedby"));
				post.setUpdateDate(resultSet.getTimestamp("updateddate"));

			}

			
		
		}finally{
			releaseResources(connection, preparedStatement, resultSet);
		}

		return post;
	}

	
	
	public List<PostBean> readAll() throws Exception{
		List<PostBean> pbList = new ArrayList<PostBean>();
		Connection connection = null;
		PreparedStatement preparedStatement = null;
		ResultSet resultSet = null;
		
		try{
			connection = getConnection();
			preparedStatement = connection.prepareStatement(SELECT_SQL_ALL);
			//preparedStatement.se
			resultSet = preparedStatement.executeQuery();
			
			while(resultSet.next()){
				PostBean post = new PostBean();
				post.setPostId(resultSet.getInt("postId"));
				post.setCreateDate(resultSet.getTimestamp("createdate"));
				post.setCreatedBy(resultSet.getString("createdby"));
				post.setTitle(resultSet.getString("title"));
				post.setShortDesc(resultSet.getString("shortdesc"));
				post.setLongDesc(resultSet.getString("longdesc"));
				post.setUpdatedBy(resultSet.getString("updatedby"));
				post.setUpdateDate(resultSet.getTimestamp("updateddate"));
				
				pbList.add(post);

			}

			
		
		}finally{
			releaseResources(connection, preparedStatement, resultSet);
		}

		return pbList;
	}
	
	
	
	public int update(PostBean post) throws Exception{
		
		Connection connection = null;
		PreparedStatement preparedStatement = null;
		ResultSet resultSet = null;
		int result = 0;

		
		try{
			connection = getConnection();
			preparedStatement = connection.prepareStatement(UPDATE_SQL);
			
			preparedStatement.setString(1, post.getTitle());
			preparedStatement.setString(2, post.getShortDesc());
			preparedStatement.setString(3, post.getLongDesc());
			preparedStatement.setString(4, post.getUpdatedBy());
			preparedStatement.setTimestamp(5, post.getUpdateDate() );			
			preparedStatement.setInt(6, post.getPostId());
			
			result = preparedStatement.executeUpdate();

		
		}finally{
			releaseResources(connection, preparedStatement, resultSet);
		}
		return result;
		
	}
	
public void delete(int postId) throws Exception{
		
		Connection connection = null;
		PreparedStatement preparedStatement = null;
		ResultSet resultSet = null;

		
		try{
			connection = getConnection();
			preparedStatement = connection.prepareStatement(DELETE_SQL);
			
		
			preparedStatement.setInt(1, postId);
			preparedStatement.execute();
			

		
		}finally{
			releaseResources(connection, preparedStatement, resultSet);
		}
		//return result;
		
	}
	
}
