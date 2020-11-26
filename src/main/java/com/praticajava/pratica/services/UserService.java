package com.praticajava.pratica.services;

import java.util.List;
import java.util.Optional;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.praticajava.pratica.entities.User;
import com.praticajava.pratica.repositories.UserRepository;


//Vai buscar todos usuários e usuários por Id.

//@Component => Essa notation registra sua classe como componenta do Spring
// Logo, vou poder usar essa classe para ser injetado com Autowired

//@repository => Registra um repositorio.

//@Service => Registra um serviço, na camada de serviço



@Service
public class UserService {
	
	@Autowired
	private UserRepository repository;
	
	//Operação na camada de serviço que repassa para camada de repository
	public List<User> findAll(){
		return repository.findAll();
	}
	
	public User findById(Long id){
		
		Optional<User> obj = repository.findById(id);
		
		//Operação get() do Optional vai retornar o objeto tipo => Optional<Tipo>
		return obj.get();
		
	}
}
