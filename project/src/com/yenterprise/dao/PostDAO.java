package com.yenterprise.dao;

import java.util.List;

import com.yenterprise.model.PostBean;

public interface PostDAO {
	 
	public void insert(PostBean post) throws Exception;
	
	public void delete(int postId) throws Exception;
	
	public PostBean read(int postId) throws Exception;
	
	public int update(PostBean post) throws Exception;
	
	public List<PostBean> readAll() throws Exception;

}
