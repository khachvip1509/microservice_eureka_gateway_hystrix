package com.test.orderservice.repository;

import org.springframework.data.jpa.repository.JpaRepository;

import com.test.orderservice.entity.Order;

public interface OrderRepository extends JpaRepository<Order, Integer>{

}
