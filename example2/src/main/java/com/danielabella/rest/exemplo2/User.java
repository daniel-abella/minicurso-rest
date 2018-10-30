package com.danielabella.rest.exemplo2;

import java.io.Serializable;

public class User implements Serializable {

	private static final long serialVersionUID = -7799369695818057571L;
	
	private int id;
	private String name;
	private String address;
	
	public User() {
	}


	public User(int id, String name, String address) {
		this.id = id;
		this.name = name;
		this.address = address;
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


	public String getAddress() {
		return address;
	}


	public void setAddress(String address) {
		this.address = address;
	}


	@Override
	public String toString() {
		return "User [id=" + id + ", name=" + name + ", address=" + address + "]";
	}

}
