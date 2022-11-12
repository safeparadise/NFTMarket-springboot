package com.example.demo.models;

import java.io.Serializable;
import java.util.List;

import javax.persistence.CollectionTable;
import javax.persistence.ElementCollection;
import javax.persistence.Entity;
import javax.persistence.EnumType;
import javax.persistence.Enumerated;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.JoinColumn;
import javax.persistence.Table;


@Entity
@Table(name = "users")
public class Users implements Serializable {
	@Id
	@GeneratedValue(strategy = GenerationType.IDENTITY)
	private int id;
	private String name;
	private String password;
	private String username;
	private boolean enabled= true;

	public String getPassword() {
		return password;
	}

	public void setPassword(String password) {
		this.password = password;
	}

	
//	public int getEnabled() {
//		return enabled;
//	}
//
//	public void setEnabled(int enabled) {
//		this.enabled = enabled;
//	}

	public boolean isEnabled() {
		return enabled;
	}

	public void setEnabled(boolean enabled) {
		this.enabled = enabled;
	}


//	@ElementCollection(targetClass = Roles.class)
//	@CollectionTable(name = "authorities", joinColumns = @JoinColumn(name = "username", referencedColumnName = "username"))
//	@Enumerated(EnumType.STRING)
//	private List<Roles> authorities ;
//
//	public List<Roles> getRoles() {
//		return authorities ;
//	}
//
//	public void setRoles(List<Roles> roles) {
//		this.authorities  = roles;
//	}

	
	public Users() {
		super();
	}

	public Users(int id, String name, String password, String username) {
		super();
		this.id = id;
		this.name = name;
		this.password = password;
		this.username = username;
	}

	public int getId() {
		return id;
	}

	public void setId(int id) {
		this.id = id;
	}

	public String getName() {
		return name;
	}

	public void setName(String name) {
		this.name = name;
	}

	public String getUsername() {
		return username;
	}

	public void setUsername(String username) {
		this.username = username;
	}
}
