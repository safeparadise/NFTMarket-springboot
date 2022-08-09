package com.example.demo.models;

import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.Id;
import javax.persistence.Table;
import javax.persistence.Transient;

import org.springframework.web.multipart.MultipartFile;

import com.fasterxml.jackson.annotation.JsonIgnore;

@Entity
@Table(name="products")
public class Products {
	@Id
	@GeneratedValue
	private int id;
	private String product_name;
	private int price;
	private String description;
	private String img;
	
	@Transient
	@JsonIgnore
	private MultipartFile file;
	
	public Products() {
		super();
	}

	public Products(int id, String product_name, int price, String description, String img) {
		super();
		this.id = id;
		this.product_name = product_name;
		this.price = price;
		this.description = description;
		this.img = img;
	}

	public String getImg() {
		return img;
	}


	public void setImg(String img) {
		this.img = img;
	}


	public MultipartFile getFile() {
		return file;
	}

	public void setFile(MultipartFile file) {
		this.file = file;
	}

	public int getId() {
		return id;
	}

	public void setId(int id) {
		this.id = id;
	}

	public String getProduct_name() {
		return product_name;
	}

	public void setProduct_name(String product_name) {
		this.product_name = product_name;
	}

	public int getPrice() {
		return price;
	}

	public void setPrice(int price) {
		this.price = price;
	}

	public String getDescription() {
		return description;
	}

	public void setDescription(String description) {
		this.description = description;
	}
	
	

}
