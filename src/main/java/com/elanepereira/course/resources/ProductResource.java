package com.elanepereira.course.resources;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import com.elanepereira.course.entities.Product;
import com.elanepereira.course.services.ProductService;

@RestController
@RequestMapping(value = "/products") //controlador rest que responde no caminho /user
public class ProductResource {
	
	@Autowired
	private ProductService service;

	@GetMapping //indica que responde a requisição do tipo get do http
	public ResponseEntity<List<Product>> findAll(){
		List<Product> list = service.findAll();
		return ResponseEntity.ok().body(list);
		//retorna a resposta de sucesso do http com a mensagem especificada no body
	}
	@GetMapping(value = "/{id}") //sempre que for uma requisicao tem de indicar o tipo, no caso GET
	public ResponseEntity<Product> findById(@PathVariable Long id){
		Product obj = service.findById(id);
		return ResponseEntity.ok(obj);
	}

}
