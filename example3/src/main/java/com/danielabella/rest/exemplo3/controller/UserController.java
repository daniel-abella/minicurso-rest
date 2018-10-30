package com.danielabella.rest.exemplo3.controller;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RestController;

import com.danielabella.rest.exemplo3.domain.User;
import com.danielabella.rest.exemplo3.service.UserService;

@RestController
public class UserController {

	private final UserService userService;

	@Autowired
	public UserController(final UserService userService) {
		this.userService = userService;
	}

	@RequestMapping(value="/user", method = RequestMethod.GET)
	public ResponseEntity< List<User> > listarUsuarios() {
		
		List<User> listaUsuarios = userService.listarTodosUsuarios();
		
		return new ResponseEntity< List<User> > (listaUsuarios, HttpStatus.OK);
	}

	@RequestMapping(value = "/user/{id}",method = RequestMethod.GET)
	public ResponseEntity<User> getUser(@PathVariable String id) {
		
		User user = userService.buscarUsuarioPorId(id);
		
		if(user == null) {
			return new ResponseEntity<User>(HttpStatus.NOT_FOUND);
		} else {
			return new ResponseEntity<User>(user, HttpStatus.OK);
		}		
	}
	
	@RequestMapping(value="/user", method = RequestMethod.POST)
	public ResponseEntity<String> createUser(@RequestBody User user) {

		try {
			userService.inserirUsuario(user);
			return new ResponseEntity<String>(HttpStatus.CREATED);

		 } catch (Exception e) {
			e.printStackTrace();
			return new ResponseEntity<String>(HttpStatus.INTERNAL_SERVER_ERROR);
		}
	}

	public UserService getUserService() {
		return userService;
	}
}
