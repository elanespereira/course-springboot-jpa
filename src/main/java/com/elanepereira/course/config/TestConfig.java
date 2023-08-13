package com.elanepereira.course.config;

import java.time.Instant;
import java.util.Arrays;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.CommandLineRunner;
import org.springframework.context.annotation.Configuration;
import org.springframework.context.annotation.Profile;

import com.elanepereira.course.entities.Category;
import com.elanepereira.course.entities.Order;
import com.elanepereira.course.entities.OrderItem;
import com.elanepereira.course.entities.Payment;
import com.elanepereira.course.entities.Product;
import com.elanepereira.course.entities.User;
import com.elanepereira.course.entities.enums.OrderStatus;
import com.elanepereira.course.repositories.CategoryRepository;
import com.elanepereira.course.repositories.OrderItemRepository;
import com.elanepereira.course.repositories.OrderRepository;
import com.elanepereira.course.repositories.ProductRepository;
import com.elanepereira.course.repositories.UserRepository;

@Configuration
@Profile("test") //mesmo nome que consta no arquivo application-test.properties
public class TestConfig implements CommandLineRunner{

	@Autowired //resolve a dependencia e associar a instancia de userrepository
	private UserRepository userRepository;
	
	@Autowired
	private OrderRepository orderRepository;
	
	@Autowired
	private CategoryRepository categoryRepository;

	@Autowired
	private ProductRepository productRepository;

	@Autowired
	private OrderItemRepository orderItemRepository;

	@Override
	public void run(String... args) throws Exception {
		
		Category cat1 = new Category(null, "Electronics");
		Category cat2 = new Category(null, "Books");
		Category cat3 = new Category(null, "Computers");
		
		categoryRepository.saveAll(Arrays.asList(cat1,cat2,cat3));

		Product p1 = new Product(null, "The Lord of the Rings", "Lorem ipsum dolor sit amet, consectetur.", 90.5, "");
		Product p2 = new Product(null, "Smart TV", "Nulla eu imperdiet purus. Maecenas ante.", 2190.0, "");
		Product p3 = new Product(null, "Macbook Pro", "Nam eleifend maximus tortor, at mollis.", 1250.0, "");
		Product p4 = new Product(null, "PC Gamer", "Donec aliquet odio ac rhoncus cursus.", 1200.0, "");
		Product p5 = new Product(null, "Rails for Dummies", "Cras fringilla convallis sem vel faucibus.", 100.99, "");

		productRepository.saveAll(Arrays.asList(p1,p2,p3,p4,p5));

		p1.getCategories().add(cat2);
		p2.getCategories().add(cat1);
		p2.getCategories().add(cat3);
		p3.getCategories().add(cat3);
		p4.getCategories().add(cat3);
		p5.getCategories().add(cat2);
		
		productRepository.saveAll(Arrays.asList(p1,p2,p3,p4,p5));

		User u1 = new User(null, "Maria Brown", "maria@gmail.com", "988888888", "123456");
		User u2 = new User(null, "Alex Green", "alex@gmail.com", "977777777", "123456"); 

		userRepository.saveAll(Arrays.asList(u1,u2));
		
		Order o1 = new Order(null, Instant.parse("2023-06-20T19:53:07Z"),OrderStatus.PAID, u1);
		Order o2 = new Order(null, Instant.parse("2023-07-21T03:42:10Z"),OrderStatus.WAITING_PAYMENT, u2);
		Order o3 = new Order(null, Instant.parse("2023-07-22T15:21:22Z"),OrderStatus.WAITING_PAYMENT, u1); 
		
		orderRepository.saveAll(Arrays.asList(o1,o2,o3));
		
		OrderItem oi1 = new OrderItem(o1, p1, 2, p1.getPrice());
		OrderItem oi2 = new OrderItem(o1, p3, 1, p3.getPrice());
		OrderItem oi3 = new OrderItem(o2, p3, 2, p3.getPrice());
		OrderItem oi4 = new OrderItem(o3, p5, 2, p5.getPrice());

		orderItemRepository.saveAll(Arrays.asList(oi1,oi2,oi3,oi4));
	
		Payment pay1 = new Payment(null,Instant.parse("2023-06-20T21:53:07Z"), o1);
		/*pra salvar um objeto dependente de um pra um nao chama o repositorio do pagamento*/
		o1.setPayment(pay1);
		/*seta o pagamento na ordem e salva novamente a ordem*/
		orderRepository.save(o1);
	}	
}
