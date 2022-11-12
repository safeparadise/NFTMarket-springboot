package com.example.demo.service;

import java.util.List;

import javax.transaction.Transactional;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.example.demo.models.Categorys;
import com.example.demo.repository.CategoryRepository;

@Service
public class CategoryService {
	
	private CategoryRepository categorysRepository;
	
	@Autowired
	public CategoryService(CategoryRepository categoryRepository){
		this.categorysRepository=categoryRepository;
	}

	public List<Categorys> getAllCategorys(){
		return categorysRepository.findAll();
	}
	
	public Categorys addCategory(Categorys category){
		return categorysRepository.save(category);
	}
	
	public Categorys editById(int id){
		return categorysRepository.findById(id);
	}
	
	@Transactional
	public String delete(int id){
		 categorysRepository.deleteById(id);
	return "";
	}
	
}
