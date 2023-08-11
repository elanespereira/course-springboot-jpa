package com.elanepereira.course.repositories;

import org.springframework.data.jpa.repository.JpaRepository;

import com.elanepereira.course.entities.Category;

public interface CategoryRepository extends JpaRepository<Category, Long>{

}
