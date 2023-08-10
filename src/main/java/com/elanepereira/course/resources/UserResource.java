package com.elanepereira.course.resources;

import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import com.elanepereira.course.entities.User;

@RestController
@RequestMapping(value = "/users") //controlador rest que responde no caminho /user
public class UserResource {

	@GetMapping //indica que responde a requisição do tipo get do http
	public ResponseEntity<User> findAll(){
		User u = new User(1L,"Elane","elanespereira@gmail.com","999999","12345654");
		return ResponseEntity.ok().body(u);
	}
}
