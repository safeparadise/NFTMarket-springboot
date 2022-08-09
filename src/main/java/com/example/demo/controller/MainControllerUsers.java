package com.example.demo.controller;

import java.io.IOException;
import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.ResponseBody;
import org.springframework.web.bind.annotation.RestController;

import com.example.demo.models.Products;
import com.example.demo.models.Users;
import com.example.demo.service.UserService;

@Controller
public class MainControllerUsers {
	

	private UserService userService;
	@Autowired
	public MainControllerUsers(UserService userservice){
		this.userService= userservice;
	}

	@RequestMapping(value={"/loginUser"}, method=RequestMethod.GET)
	public@ResponseBody Users addUsers(Users users){
		return userService.addUser(users);
	}
	
}
