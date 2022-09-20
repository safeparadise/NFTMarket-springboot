package com.example.demo.service;

import java.util.List;
import java.util.Optional;

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
	
	public List<Users> getThree(){
		return userRepository.getThreeUser();
	}
	
	public Users addUser(Users users){
		return userRepository.save(users);
	}

	public List<Users> getAllUsers(){
		return userRepository.findAll();
	}
	
	public Users findByID(int id){
		return userRepository.findByid(id);
	}
}