package com.example.food_order_service.repository;

//package repository;

import org.springframework.data.jpa.repository.JpaRepository;
import com.example.food_order_service.entity.FoodOrder;

public interface FoodOrderRepository
        extends JpaRepository<FoodOrder, Long> {
}