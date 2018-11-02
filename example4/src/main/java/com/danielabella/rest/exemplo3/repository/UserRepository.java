package com.danielabella.rest.exemplo3.repository;

import org.springframework.data.jpa.repository.JpaRepository;

import com.danielabella.rest.exemplo3.domain.User;

public interface UserRepository extends JpaRepository<User, String> {

	public User findByName(String name);
	
}
