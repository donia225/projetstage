package com.example.demo.service;

import java.util.List;

import com.example.demo.entities.User;

public interface UserService {
	User saveUser(User u);
	User updateUser(User u);
	void deleteUser(User u);
	void deleteUserById(Long id);
	User getUser(Long id);
	List<User> getAllusers();
	 User authenticateCliente(String email, String password);
}
