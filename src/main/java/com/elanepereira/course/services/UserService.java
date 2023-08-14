package com.elanepereira.course.services;

import java.util.List;
import java.util.Optional;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;
import org.springframework.stereotype.Service;

import com.elanepereira.course.entities.User;
import com.elanepereira.course.repositories.UserRepository;

@Service
//@Component eh generico. O @service eh mais especifico para o caso
public class UserService {

	@Autowired
	private UserRepository repository;
	
	public List<User> findAll(){
		return repository.findAll();
	}
	
	public User findById(Long id) {
		Optional<User> obj = repository.findById(id);
		return obj.get();
	}

	public User insert(User obj) {
		return repository.save(obj);
	}
	public void delete(Long id) {
		repository.deleteById(id);
	}
}
