package com.example.food_order_service.service;

//package service;

import java.util.List;

import org.springframework.http.HttpStatus;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;
import org.springframework.web.server.ResponseStatusException;

import com.example.food_order_service.entity.FoodOrder;
import com.example.food_order_service.repository.FoodOrderRepository;

@Service
@Transactional
public class FoodOrderService {

    private final FoodOrderRepository repository;

    public FoodOrderService(FoodOrderRepository repository) {
        this.repository = repository;
    }

    // GET all orders
    public List<FoodOrder> getAllOrders() {
        return repository.findAll();
    }

    // GET order by ID
    public FoodOrder getOrderById(Long id) {
        return repository.findById(id)
            .orElseThrow(() -> new ResponseStatusException(
                HttpStatus.NOT_FOUND, "Order not found: " + id));
    }

    // POST - Add order
    public FoodOrder addOrder(FoodOrder order) {
        order.setOrderId(null);
        return repository.save(order);
    }

    // PUT - Update entire order
    public FoodOrder updateOrder(Long id, FoodOrder updated) {
        FoodOrder existing = getOrderById(id);

        existing.setCustomerName(updated.getCustomerName());
        existing.setFoodItem(updated.getFoodItem());
        existing.setQuantity(updated.getQuantity());
        existing.setPrice(updated.getPrice());

        return repository.save(existing);
    }

    // DELETE - Delete order
    public void deleteOrder(Long id) {
        repository.delete(getOrderById(id));
    }

    // PATCH - Partial update
    public FoodOrder patchOrder(Long id, FoodOrder changes) {
        FoodOrder existing = getOrderById(id);

        if (changes.getCustomerName() != null) {
            existing.setCustomerName(changes.getCustomerName());
        }

        if (changes.getFoodItem() != null) {
            existing.setFoodItem(changes.getFoodItem());
        }

        if (changes.getQuantity() != null) {
            existing.setQuantity(changes.getQuantity());
        }

        if (changes.getPrice() != null) {
            existing.setPrice(changes.getPrice());
        }

        // Validate the final merged order.
        if (existing.getCustomerName() == null
                || existing.getCustomerName().isBlank()) {
            throw new ResponseStatusException(
                HttpStatus.BAD_REQUEST, "Customer name is required");
        }

        if (existing.getFoodItem() == null
                || existing.getFoodItem().isBlank()) {
            throw new ResponseStatusException(
                HttpStatus.BAD_REQUEST, "Food item cannot be empty");
        }

        if (existing.getQuantity() == null
                || existing.getQuantity() < 1) {
            throw new ResponseStatusException(
                HttpStatus.BAD_REQUEST, "Quantity must be at least 1");
        }

        if (existing.getPrice() == null
                || existing.getPrice().signum() < 0) {
            throw new ResponseStatusException(
                HttpStatus.BAD_REQUEST, "Price cannot be negative");
        }

        return repository.save(existing);
    }
}