package com.praticajava.pratica.resources;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import com.praticajava.pratica.entities.User;
import com.praticajava.pratica.services.UserService;

@RestController    /*Notação para fala que esse recurso vai usar controlador REST*/
@RequestMapping(value = "/users")   /*Caminho do meu recurso (rota do node)*/
public class UserResource {
	
	//Dependência com Service (User) =>  Repositories <-> Service <-> Resource
	// Todo servico deve ser registrado.
	// Para isso funcionar a classe UserService deve está registrada como componente do Spring.
	
	@Autowired
	private UserService service;
	
	
	
	//Método end-point para acessar os usuários 
	// ResponseEntity<T> => Tipo de retorno para retornar repostas de requisições web do recurso.
	// <User> => Tipo da minha resposta vai ser clsse User.
	
	//GetMapping => Para indicar que esse método responde a requisição do tipo Get do HTTP
	@GetMapping
	public ResponseEntity<List<User>> findAll(){
		
		List<User> list = service.findAll();
		
		return ResponseEntity.ok().body(list);
	}
	
	@GetMapping(value = "/{id}")
	public ResponseEntity<User> findById(@PathVariable Long id){
		
		User obj = service.findById(id);
		
		return ResponseEntity.ok().body(obj);
	}
}
