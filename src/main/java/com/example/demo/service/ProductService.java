package com.example.demo.service;

import java.io.File;
import java.io.FileNotFoundException;
import java.io.IOException;
import java.nio.file.Files;
import java.nio.file.Path;
import java.nio.file.Paths;
import java.util.List;
import java.util.Objects;
import java.util.UUID;

import javax.annotation.Resource;
import javax.transaction.Transactional;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.util.ResourceUtils;

import com.example.demo.models.Products;
import com.example.demo.repository.ProductRepository;

@Service
public class ProductService {

	private ProductRepository productRepository;

	@Autowired
	public ProductService(ProductRepository productRepository) {
		this.productRepository = productRepository;
	}

	public List<Products> getAllProducts() {
		return productRepository.findAll();
	}

	public Products addProducts(Products product) {
		return productRepository.save(product);
	}
	
	public Products findByIdProduct(int id) {
		return productRepository.findById(id);
	}
	public List<Products> gettingFour(){
		return productRepository.getFourNFT();
	}

	@Transactional
	public Products registerIMG(Products product) throws IOException {
		String path = ResourceUtils.getFile("classpath:static/img").getAbsolutePath();
//		
		System.out.println("the place of img saving in ->"+path);
		byte[] bytes = product.getFile().getBytes();
		System.out.println(bytes);
//		String name = UUID.randomUUID() + "."
//				+ Objects.requireNonNull(product.getFile().getContentType()).split("/")[1];
		String name = product.getFile().getOriginalFilename();
		System.out.println(name);
		
//		String name = product.getFile().getOriginalFilename();
		Files.write(Paths.get(path + File.separator + name), bytes);
		product.setImg(name);
//		System.out.println("-------------------------------------------");
//		System.out.println(this.productRepository.save(product.getImg()));
//		System.out.println("-------------------------------------------");
		return this.productRepository.save(product);

	}
}
