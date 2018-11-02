package com.danielabella.rest.exemplo3.service;

import java.util.List;

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

	@Autowired
	private UserRepository repository;

	public User buscarUsuarioPorId(String id) {
		return repository.findOne(id);
	}

	public List<User> listarTodosUsuarios() {
		return repository.findAll();
	}

	@Transactional
	public User inserirUsuario(User usuario) throws UserAlreadyExistsException {

		User existing = repository.findByName(usuario.getName());

		if (existing != null) {
			throw new UserAlreadyExistsException("Existe um usuario com  o nome " + usuario.getName());
		}

		return repository.save(usuario);
	}

	public UserRepository getRepository() {
		return repository;
	}

	public void setRepository(UserRepository repository) {
		this.repository = repository;
	}

}
