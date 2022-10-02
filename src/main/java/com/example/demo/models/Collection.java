package com.example.demo.models;

import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.Table;
import javax.persistence.Transient;

import org.springframework.web.multipart.MultipartFile;

import com.fasterxml.jackson.annotation.JsonIgnore;

@Entity
@Table(name="collection")
public class Collection {
	@Id
	@GeneratedValue(strategy = GenerationType.IDENTITY)
	private int id;
	private int creator;
	private String name;
	private String cover;
	
	@JsonIgnore
	@Transient
	private MultipartFile file;
	 
	public MultipartFile getFile() {
		return file;
	}

	public void setFile(MultipartFile file) {
		this.file = file;
	}

	public Collection() {
		super();
	}
	
	public Collection(int id, int creator, String name, String creator_img, String cover) {
		super();
		this.id = id;
		this.creator = creator;
		this.name = name;
		this.cover = cover;
	}
	public int getId() {
		return id;
	}
	public void setId(int id) {
		this.id = id;
	}
	public int getCreator() {
		return creator;
	}
	public void setCreator(int creator) {
		this.creator = creator;
	}

	public String getName() {
		return name;
	}

	public void setName(String name) {
		this.name = name;
	}

	public String getCover() {
		return cover;
	}

	public void setCover(String cover) {
		this.cover = cover;
	}
	
	
}
