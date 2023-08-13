package com.elanepereira.course.repositories;

import org.springframework.data.jpa.repository.JpaRepository;

import com.elanepereira.course.entities.OrderItem;

public interface OrderItemRepository extends JpaRepository<OrderItem, Long>{

}
