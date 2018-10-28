package com.danielabella.rest.exemplo1;

import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RestController;

@RestController
public class UserController {

	@RequestMapping(value="/usuario", method = RequestMethod.GET)
	public String listarTodosUsuarios() {
		//iria ao bd, listaria todos os usuarios e retornaria.
		return "todos";
	}

	@RequestMapping(value="/usuario/{identificador}", method = RequestMethod.GET)
	public String obterInformacaoUsuario(@PathVariable String identificador) {
		return "Ola, Meu Amigo Desenrolado que possui o ID = " + identificador;
	}
	
	@RequestMapping(value="/usuario", method = RequestMethod.POST)
	public String createParticipant(@RequestBody User user) {

		try {
			System.out.println(user.getName());
			return "foi persistido o usuario " + user.getName();

		} catch (Exception e) {
			e.printStackTrace();
		}
		
		return null;
	}
	
	@RequestMapping(value="/usuario/{identificador}", method = RequestMethod.PUT)
	public String atualizarUsuario(@PathVariable String identificador) {
		return "Vamos atualizar quem tem o ID " + identificador;
	}

	@RequestMapping(value="/usuario/{identificador}", method = RequestMethod.DELETE)
	public String excluir(@PathVariable String identificador) {
		return "Vamos excluir quem tem o ID " + identificador;
	}

}
