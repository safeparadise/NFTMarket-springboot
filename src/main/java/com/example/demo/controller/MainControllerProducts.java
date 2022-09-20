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
import com.example.demo.service.CollectionService;
import com.example.demo.service.ProductService;
import com.example.demo.service.UserService;

@Controller
@RequestMapping("/admin")
public class MainControllerProducts {
	
	private ProductService productservice;
	
	@Autowired
	public MainControllerProducts(ProductService productsservice) {
		this.productservice = productsservice;
	}
	//finish router pages
	
	@RequestMapping(value={"/p"}, method=RequestMethod.POST)
	public String addProducts(@ModelAttribute Products product) throws IOException{
		System.out.println("----------------------------------------");
//		System.out.println(product.getPrice());
//		System.out.println(product.getImg());
//		System.out.println(productservice.registerIMG(product));
		productservice.registerIMG(product);
		System.out.println("----------------------------------------");
		return "index.html";
	}
	
	@RequestMapping(value="/product/edit/{id}", method=RequestMethod.GET)
	public String editProduct(Model model,@PathVariable("id") int id){
		model.addAttribute("product",productservice.findByIdProduct(id));
		return "/AdminPanel/productEdit.html";
	}
	
	
	@RequestMapping("/products")
	public String listProducts(Model model){
		model.addAttribute("products", productservice.getAllProducts());
		return "/AdminPanel/products.html";
	}
	
	@RequestMapping(value={"/product/add"}, method=RequestMethod.GET)
	public String addNewProduct(){
		return "AdminPanel/productEdit.html";
	}
	
	@RequestMapping("/productsTbl")
	public String productsTbl(Model model){
		model.addAttribute("products",productservice.getAllProducts());
		return "/form/producttbl.html";
	}
	
	
	@RequestMapping(value="/get", method=RequestMethod.GET)
	public@ResponseBody List<Products> getFourProduct(){
		return productservice.gettingFour();
	}
}
