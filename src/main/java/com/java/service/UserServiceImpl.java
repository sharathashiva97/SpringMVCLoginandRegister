package com.java.service;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import com.java.Dao.UserDao;
import com.java.model.User;
import com.java.service.UserService;

@Service

public class UserServiceImpl implements UserService {

	@Autowired
	private UserDao userDao;
	@Transactional
	
	public void create(User user) {
		userDao.create(user);

	}
	@Transactional
	
	public void update(User user) {
		userDao.update(user);

	}
	@Transactional
	
	public void delete(User user) {
		userDao.delete(user);

	}
	@Transactional
	
	public User edit(Long userId) {
		
		return userDao.edit(userId);
	}
	@Transactional
	
	public User find(Long userId) {
		
		return userDao.find(userId);
	} 
	@Transactional
	
	public List<User> getAll() {
		
		return userDao.getAll();
	}
	
	public String loginUser(User user) {

		return userDao.loginUser(user);
	}
	public User getEmpById(Long id) {
		return userDao.getEmpById(id);
	}
	public List<User> get(User user) {
		return userDao.get(user);
	}
	

	
	
	

}