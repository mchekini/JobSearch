package com.needjob.dao;

import java.util.List;

import com.needjob.model.*;

public interface UserDao {
	
	public void store(User user);
	public void delete (User user);
	public  List<User> getAllUsers();
	public User FindUserById(int id);

}
