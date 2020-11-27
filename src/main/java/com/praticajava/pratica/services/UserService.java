package com.praticajava.pratica.services;

import java.util.List;
import java.util.Optional;

import javax.persistence.EntityNotFoundException;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.dao.DataIntegrityViolationException;
import org.springframework.dao.EmptyResultDataAccessException;
import org.springframework.stereotype.Service;

import com.praticajava.pratica.entities.User;
import com.praticajava.pratica.repositories.UserRepository;
import com.praticajava.pratica.services.exceptions.DatabaseException;
import com.praticajava.pratica.services.exceptions.ResourceNotFoundException;

//Vai buscar todos usuários e usuários por Id.

//@Component => Essa notation registra sua classe como componenta do Spring
// Logo, vou poder usar essa classe para ser injetado com Autowired

//@repository => Registra um repositorio.

//@Service => Registra um serviço, na camada de serviço

@Service
public class UserService {

	@Autowired
	private UserRepository repository;

	// Operação na camada de serviço que repassa para camada de repository
	public List<User> findAll() {
		return repository.findAll();
	}

	public User findById(Long id) {

		Optional<User> obj = repository.findById(id);

		// Operação get() do Optional vai retornar o objeto tipo => Optional<Tipo>
		return obj.orElseThrow(() -> new ResourceNotFoundException(id));

	}

	// Metodo save já retorna o obj
	public User insert(User obj) {
		return repository.save(obj);
	}

	public void delete(Long id) {
		try {
			repository.deleteById(id);
		} catch (EmptyResultDataAccessException e) {
			throw new ResourceNotFoundException(id);
		} catch (DataIntegrityViolationException e) {
			throw new DatabaseException(e.getMessage());
		}
	}

	public User update(Long id, User obj) {
		// GetOne so vai deixa um objeto monitorado pelo JPA para eu trabalhar com ele e
		// em seguida efetuar operaçao com bd

		try {
			User entity = repository.getOne(id);
			updateData(entity, obj);
			return repository.save(entity);
		} catch (EntityNotFoundException e) {
			throw new ResourceNotFoundException(id);
		} 
	}

	private void updateData(User entity, User obj) {
		entity.setName(obj.getName());
		entity.setEmail(obj.getEmail());
		entity.setPhone(obj.getPhone());
	}
}
