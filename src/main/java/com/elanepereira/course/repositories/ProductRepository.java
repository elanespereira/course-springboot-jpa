package com.elanepereira.course.repositories;

import org.springframework.data.jpa.repository.JpaRepository;

import com.elanepereira.course.entities.Product;

public interface ProductRepository extends JpaRepository<Product, Long>{

}
