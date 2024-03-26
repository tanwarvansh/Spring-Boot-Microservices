package com.example.OrderService.repository;

import org.springframework.data.jpa.repository.JpaRepository;

import com.example.OrderService.entity.Order;

public interface OrderRepository extends JpaRepository<Order,Long>{

}
