package com.elanepereira.course.repositories;

import org.springframework.data.jpa.repository.JpaRepository;

import com.elanepereira.course.entities.User;

public interface UserRepository extends JpaRepository<User, Long>{

}
