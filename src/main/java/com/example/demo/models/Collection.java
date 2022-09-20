package com.example.demo.models;

import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.Table;

@Entity
@Table(name="collection")
public class Collection {
	@Id
	@GeneratedValue(strategy = GenerationType.IDENTITY)
	private int id;
	private int creator;
	private String name;
	private String creator_img;
	private String cover;
	
	 
	public Collection() {
		super();
	}
	
	public Collection(int id, int creator, String name, String creator_img, String cover) {
		super();
		this.id = id;
		this.creator = creator;
		this.name = name;
		this.creator_img = creator_img;
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

	public String getCreator_img() {
		return creator_img;
	}

	public void setCreator_img(String creator_img) {
		this.creator_img = creator_img;
	}

	public String getCover() {
		return cover;
	}

	public void setCover(String cover) {
		this.cover = cover;
	}
	
	
}
