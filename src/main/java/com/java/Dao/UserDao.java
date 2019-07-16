package com.java.Dao;

import java.util.List;

import com.java.model.User;

public interface UserDao {
public void create(User user);
	
	String loginUser(User user);
	public void update(User user);
	public void delete(User user);
	public User edit(Long userId);
	public User find(Long userId);
	public List<User> getAll();

	public User getEmpById(Long id);

	public List<User> get(User user);
	

}
