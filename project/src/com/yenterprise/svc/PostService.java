package com.yenterprise.svc;

import java.util.ArrayList;
import java.util.List;

import com.yenterprise.dao.PostDAO;
import com.yenterprise.dao.UserDAO;
import com.yenterprise.dao.jdbc.PostJdbcDAO;
import com.yenterprise.dao.jdbc.UserJdbcDAO;
import com.yenterprise.model.PostBean;
import com.yenterprise.model.UserBean;



public final class PostService {
	
	private PostDAO postDAO;
	private UserDAO userDAO;

	
	public PostService(){
		postDAO = new PostJdbcDAO();
		userDAO= new UserJdbcDAO();
		
	}

	public UserBean userLogin(UserBean user){
		
		try{
			user=userDAO.login(user);
		}catch (Exception ex){
			ex.printStackTrace();
		}
		return user;
	}
	
	
	
	public PostBean getPost(int postId){
		PostBean post=new PostBean();
		try{
			post=postDAO.read(postId);
			
		}catch (Exception ex){
			post.setLongDesc(ex.toString());
			//ex.printStackTrace();
		}
		
		return post;
	}
	
	
	
	public List<PostBean> getAllPosts(){
		List<PostBean> postList = new ArrayList<PostBean>();
		try{
			postList = postDAO.readAll();
		}catch (Exception ex){
			PostBean post=new PostBean();
			post.setShortDesc(ex.toString());
			postList.add(post);
		
			//ex.printStackTrace();
		}
		
		return postList;
	}
	
	public boolean updatePost(PostBean post){
		try{
			if(postDAO.update(post)>0){
				return true;
			} else{
				return false;
			}
			
			}catch (Exception ex){
				//ex.printStackTrace();
				return false;
			}
	}
	
	public boolean newPost(PostBean post){
		try{
			postDAO.insert(post);
				return true;
			
			}catch (Exception ex){
				//ex.printStackTrace();
				return false;
			}
	}
	
}
