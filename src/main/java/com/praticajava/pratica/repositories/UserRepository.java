package com.praticajava.pratica.repositories;

import org.springframework.data.jpa.repository.JpaRepository;

import com.praticajava.pratica.entities.User;

// 	Interface para acessar o banco e fazer operações.
//	Subframework do ecossistema spring.
//	Repository resposánvel por fazer operação com Entidade User.
// 	Nossos repositories serão interfaces.
//	Porque JPARespository é uma interface tbm.

//Não preciso implementar essa interface, pq o spring data jpa já tem uma implementação padra para essa interface.

//A interface do UserRepository não precisa usar notation (@service, @component..), 
// por causa da 'extends JpaRepository' que é um @repository

public interface UserRepository extends JpaRepository<User, Long>{
	
}
