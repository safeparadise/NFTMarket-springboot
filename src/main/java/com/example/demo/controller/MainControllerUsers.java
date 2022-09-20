package com.example.demo.controller;

import java.io.IOException;
import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.ResponseBody;
import org.springframework.web.bind.annotation.RestController;

import com.example.demo.models.Products;
import com.example.demo.models.Users;
import com.example.demo.service.UserService;

@Controller
@RequestMapping("/admin")
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
	
	@RequestMapping("/users" )
	public String usersAdminPanel(Model model){
		model.addAttribute("users", userService.getAllUsers());
		return "/AdminPanel/users.html";
	}
	@RequestMapping(value="/users/edit/{id}",method=RequestMethod.GET )
	public String usersEdit(Model model,@PathVariable("id") int id){
		model.addAttribute("userDetails", userService.findByID(id));
		System.out.println(userService.findByID(id).getId());
		return "/AdminPanel/usersEdit.html";
	}
}
