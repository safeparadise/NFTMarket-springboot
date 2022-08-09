package com.example.demo.service;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.example.demo.models.Users;
import com.example.demo.repository.UserRepository;

@Service
public class UserService {
	private UserRepository userRepository;
	
	@Autowired
	public UserService(UserRepository userRepo){
		this.userRepository = userRepo;
	}
	
	public Users addUser(Users users){
		return userRepository.save(users);
	}

	public List<Users> getAllUsers(){
		return userRepository.findAll();
	}
}
