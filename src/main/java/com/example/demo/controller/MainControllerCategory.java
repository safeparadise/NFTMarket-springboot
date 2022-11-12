package com.example.demo.controller;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;

import com.example.demo.models.Categorys;
import com.example.demo.models.Collection;
import com.example.demo.service.CategoryService;

@Controller
@RequestMapping("admin")
public class MainControllerCategory {

	private CategoryService categorysService;
	
	@Autowired
	public MainControllerCategory(CategoryService categoryService){
		this.categorysService = categoryService;
	}
	
	@RequestMapping("/categories")
	public String categoryTable(Model model){
		model.addAttribute("categories", categorysService.getAllCategorys());
		return "/AdminPanel/category.html";
	}
	
	@RequestMapping("/categories/add")
	public String addingCategory(){
		return "/AdminPanel/categoryEdit.html";
	}
	
	@RequestMapping(value="/categories/save", method=RequestMethod.GET)
	public String rediretToCategoryTable(@ModelAttribute Categorys categories){
		categorysService.addCategory(categories);
		return "redirect:/admin/categories";
	}
	
	@RequestMapping(value="/categories/edit/{id}", method=RequestMethod.GET)
	public String editingTheCategory(Model model, @PathVariable("id") int id){
		model.addAttribute("categories", categorysService.editById(id));
		return "/AdminPanel/categoryEdit.html";
	}
	
	@RequestMapping(value="categories/delete/{id}",method=RequestMethod.GET)
	public String delete(@PathVariable("id") int id){
		 categorysService.delete(id);
		 return "redirect:/admin/categories";
		 
	}
	
	@RequestMapping(value="/editCategoryParams", method=RequestMethod.GET)
	public String saveChange(@ModelAttribute Categorys category){
		System.out.println("----------------------------------");
		System.out.println(category.getId());
		System.out.println("----------------------------------");
		categorysService.addCategory(category);
		return "redirect:/admin/categoryies";
	}
	
//	editCategoryParams
}
