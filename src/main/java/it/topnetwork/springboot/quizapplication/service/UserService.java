package it.topnetwork.springboot.quizapplication.service;

import java.util.List;

import it.topnetwork.springboot.quizapplication.entity.User;


public interface UserService {

public List<User> findAll();
	
	public User findById(int theId);
	
	public void save(User theUser);
	
	public void delete(int TheId);
	
}
