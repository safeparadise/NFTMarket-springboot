package com.example.demo.controller;

import java.io.IOException;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;

import com.example.demo.models.Collection;
import com.example.demo.service.CollectionService;

@Controller
@RequestMapping("/admin")
public class MainControllerCollections {

	private CollectionService collectionService;
	
	@Autowired
	public MainControllerCollections(CollectionService collectionService){
		this.collectionService = collectionService;
	}
	
	@RequestMapping("/collections")
	public String collectionAdminList(Model model){
		model.addAttribute("collections", collectionService.getAllcollection());
		return "/AdminPanel/collection.html";
	}
	
	@RequestMapping("/collection/edit/{id}")
	public String collectionEdit(@PathVariable("id") int id, Model model){
		model.addAttribute("collection", collectionService.getCollection(id));
		return "/AdminPanel/collectionEdit.html";
	}
	
	@RequestMapping("/collection/add")
	public String collectionAdd(){
		return "/AdminPanel/collectionEdit.html";
	}
	
	@RequestMapping("/collection/create")
	public String createCollection(Collection collection) throws IOException{
		collectionService.addCollection(collection);
		return "redirect:/admin/collections";
	}
}
