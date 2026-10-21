//package com.example.food_order_service.controller;
//
////package controller;
//
//import java.util.List;
//
//import org.springframework.http.HttpStatus;
//import org.springframework.http.ResponseEntity;
//import org.springframework.web.bind.annotation.*;
//
//import jakarta.validation.Valid;
//
//import com.example.food_order_service.entity.FoodOrder;
//import com.example.food_order_service.service.FoodOrderService;
//
//@RestController
//@RequestMapping("/api/orders")
//public class FoodOrderController {
//
//    private final FoodOrderService service;
//
//    public FoodOrderController(FoodOrderService service) {
//        this.service = service;
//    }
//
//    // GET - All orders
//    @GetMapping
//    public List<FoodOrder> getAllOrders() {
//        return service.getAllOrders();
//    }
//
//    // GET - By ID
//    @GetMapping("/{id}")
//    public FoodOrder getOrderById(@PathVariable Long id) {
//        return service.getOrderById(id);
//    }
//
//    // POST - Create order
//    @PostMapping
//    public ResponseEntity<FoodOrder> addOrder(
//            @Valid @RequestBody FoodOrder order) {
//
//        return ResponseEntity.status(HttpStatus.CREATED)
//            .body(service.addOrder(order));
//    }
//
//    // PUT - Update order
//    @PutMapping("/{id}")
//    public FoodOrder updateOrder(
//            @PathVariable Long id,
//            @Valid @RequestBody FoodOrder order) {
//
//        return service.updateOrder(id, order);
//    }
//
//    // DELETE - Remove order
//    @DeleteMapping("/{id}")
//    public ResponseEntity<Void> deleteOrder(
//            @PathVariable Long id) {
//
//        service.deleteOrder(id);
//        return ResponseEntity.noContent().build();
//    }
//
//    // PATCH - Partial update
//    @PatchMapping("/{id}")
//    public FoodOrder patchOrder(
//            @PathVariable Long id,
//            @RequestBody FoodOrder changes) {
//
//        return service.patchOrder(id, changes);
//    }
//}










package com.example.food_order_service.controller;

import com.example.food_order_service.entity.FoodOrder;
import com.example.food_order_service.service.FoodOrderService;
import org.springframework.web.bind.annotation.*;
import java.util.List;

@RestController
@RequestMapping("/orders")
public class FoodOrderController {

    private final FoodOrderService foodOrderService;

    public FoodOrderController(FoodOrderService foodOrderService) {
        this.foodOrderService = foodOrderService;
    }

    @GetMapping
    public List<FoodOrder> getAllOrders() {
        return foodOrderService.getAllOrders();
    }
}