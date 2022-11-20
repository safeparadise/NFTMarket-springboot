package com.example.demo.service;

import java.lang.reflect.InvocationTargetException;
import java.util.List;
import java.util.Optional;

import javax.transaction.Transactional;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.example.demo.models.Users;
import com.example.demo.repository.UserRepository;
import com.example.demo.tools.ApacheBeanUtils;

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
	@Transactional
	public String delete(int id){
		 userRepository.deleteById(id);
	return "";
	}
	
	public Users updateUsers(Users users) throws IllegalAccessException, InvocationTargetException{
		if(users.getUsername() != null){
			Users exist = userRepository.findByid(users.getId());
			ApacheBeanUtils abu = new ApacheBeanUtils();
			abu.copyProperties(exist, users);
			return userRepository.save(exist);
		}
		return userRepository.save(users);
	}
}
