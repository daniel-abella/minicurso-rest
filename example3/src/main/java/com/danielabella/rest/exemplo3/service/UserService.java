package com.danielabella.rest.exemplo3.service;

import java.util.List;

import javax.validation.Valid;
import javax.validation.constraints.NotNull;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;
import org.springframework.validation.annotation.Validated;

import com.danielabella.rest.exemplo3.domain.User;
import com.danielabella.rest.exemplo3.exceptions.UserAlreadyExistsException;
import com.danielabella.rest.exemplo3.repository.UserRepository;

@Service
@Validated
public class UserService {

    private final UserRepository repository;

    @Autowired
    public UserService(final UserRepository repository) {
        this.repository = repository;
    }
    
    public User getById(String id) {    
    	return repository.findOne(id);
    }
    
	public List<User> listAllUsers() {
		return repository.findAll();
	}
	
    @Transactional
    public User save(@NotNull @Valid final User participant) throws UserAlreadyExistsException {
    	
    	/*
        User existing = repository.findByName(participant.getName());
        
        if (existing != null) {
            throw new UserAlreadyExistsException(String.format("There already exists a participant with email=%s", participant.getName()));
        }
        */
        
        return repository.save(participant);
    }

	public UserRepository getRepository() {
		return repository;
	}
}
