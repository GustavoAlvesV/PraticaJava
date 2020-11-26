package com.praticajava.pratica.config;

import java.time.Instant;
import java.util.Arrays;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.CommandLineRunner;
import org.springframework.context.annotation.Configuration;
import org.springframework.context.annotation.Profile;

import com.praticajava.pratica.entities.Category;
import com.praticajava.pratica.entities.Order;
import com.praticajava.pratica.entities.User;
import com.praticajava.pratica.entities.enums.OrderStatus;
import com.praticajava.pratica.repositories.CategoryRepository;
import com.praticajava.pratica.repositories.OrderRepository;
import com.praticajava.pratica.repositories.UserRepository;

//Classe de configuração é auxiliar para configuração da minha app
// Config responsável por popular banco h-2 com usuários.

// @Configuration => Para falar com spring que essa é uma classe específica de configuração.

// @Profile("test") => Para falar que a classe é uma configuração especifica para perfil de 'test'
// Ou seja, spring so vai rodar essa config quando estiver no perfil de 'test'.

//Database seeding => Popular nosso banco de dados 'test'.

//Implements => Executar isso quando programa for executado CommandLineRunner

//Metodo run => Tudo lá dentro vai ser executado quando app for iniciada.


@Configuration
@Profile("test")
public class TestConfig implements CommandLineRunner{

	//Vai Associar instância de userRepos. aqui dentro. 
	// Ou seja, vai fazer uma injenção de dependencia automática feita pelo container do framework.
	@Autowired
	private UserRepository userRepository;

	@Autowired
	private OrderRepository orderRepository;

	@Autowired
	private CategoryRepository categoryRepository;

	
	
	@Override
	public void run(String... args) throws Exception {
		
		User u1 = new User(null, "Maria Brown", "maria@gmail.com", "988888888", "123456");
		User u2 = new User(null, "Alex Green", "alex@gmail.com", "977777777", "123456");
		

		// 2019-06-20T19:53:07Z => z -> Horario padrao GMT (grenwich)
		Order o1 = new Order(null, Instant.parse("2019-06-20T19:53:07Z"),OrderStatus.PAID, u1);
		Order o2 = new Order(null, Instant.parse("2019-07-21T03:42:10Z"),OrderStatus.WAITING_PAYMENT, u2);
		Order o3 = new Order(null, Instant.parse("2019-07-22T15:21:22Z"),OrderStatus.WAITING_PAYMENT, u1);
		
		Category cat1 = new Category(null, "Electronics");
		Category cat2 = new Category(null, "Books");
		Category cat3 = new Category(null, "Computers");
		
		userRepository.saveAll(Arrays.asList(u1, u2));
		orderRepository.saveAll(Arrays.asList(o1, o2, o3));
		categoryRepository.saveAll(Arrays.asList(cat1,cat2,cat3));
		
	}
	
	
}
