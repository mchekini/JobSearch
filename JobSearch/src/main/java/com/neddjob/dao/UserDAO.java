package com.neddjob.dao;

import java.util.List;

import com.needjob.model.*;

public interface UserDAO {
	
	
	public void store(User user);
	public void delete(User user);
	public List<User> getAllUsers();
	public User findUserByid(int id);

}
