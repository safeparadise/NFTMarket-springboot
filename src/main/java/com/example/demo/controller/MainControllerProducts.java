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
import com.example.demo.service.ProductService;

@Controller
public class MainControllerProducts {
	
	private ProductService productservice;
	
	@Autowired
	public MainControllerProducts(ProductService productsservice) {
		this.productservice = productsservice;
	}

	@RequestMapping("/")
	public String index(Model model){
		model.addAttribute("products",productservice.getAllProducts());
		return "index.html";
	}
	
	@RequestMapping("/notfound")
	public String Notfound(Model model){
		return "user/notfound.html";
	}
	
	@RequestMapping(value={"/product"}, method=RequestMethod.GET)
	public@ResponseBody Products addProducts( Products product){
		return productservice.addProducts(product);
	}
	
	@RequestMapping(value={"/pro"}, method=RequestMethod.GET)
	public@ResponseBody List<Products> getting(){
		return productservice.getAllProducts();
	}
	
	@RequestMapping(value={"/products"}, method=RequestMethod.POST)
	public Products addProductsImges(@ModelAttribute Products product) throws IOException{
		return productservice.registerIMG(product);
	}
	@RequestMapping("/login" )
	public String login(){
		return "/user/login.html";
	}
	
	@RequestMapping("/productsTbl")
	public String productsTbl(Model model){
		model.addAttribute("products",productservice.getAllProducts());
		return "/form/producttbl.html";
	}
	
	@RequestMapping(value="/edit/{id}", method=RequestMethod.GET)
	public String editProduct(Model model,@PathVariable("id") int id){
		model.addAttribute("products",productservice.findByIdProduct(id));
		return "/form/productreg.html";
	}
}
