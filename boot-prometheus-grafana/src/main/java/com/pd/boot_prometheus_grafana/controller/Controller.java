package com.pd.boot_prometheus_grafana.controller;

import lombok.Getter;
import lombok.Setter;
import lombok.extern.slf4j.Slf4j;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.web.bind.annotation.*;

import java.util.HashMap;
import java.util.List;
import java.util.Map;
import java.util.Set;

@RestController
public class Controller {

    private static Map<Integer, Order> orderMap= new HashMap<>();
    Logger log = LoggerFactory.getLogger(Controller.class);
    @GetMapping("/order/{orderId}")
    public Order getOrder(@PathVariable int orderId) {
        log.info("Fetch order [{}]", orderId);
        return orderMap.get(orderId);
    }
    @PostMapping("/order")
    public Order createOrder(@RequestBody Order order) {
        log.info("Create order [{}]", order);
        return orderMap.put(order.getOrderId(),order);
    }
    @PatchMapping("/order")
    public Order patchOrder(@RequestBody Order order) {
        log.info("Update order [{}]", order);
        return orderMap.put(order.getOrderId(),order);
    }
    @GetMapping("/delete/order/{order}")
    public Order deleteOrder(@PathVariable int order) {
        log.info("Delete order [{}]", order);
        return orderMap.remove(order);
    }
    @GetMapping("/orders")
    public List<Order> ordersAll() {
        log.info("all order");
        return orderMap.values().stream().toList();
    }
}


class Order{
    private int orderId;
    private String item;
    private double amount;

    public int getOrderId() {
        return orderId;
    }

    public void setOrderId(int orderId) {
        this.orderId = orderId;
    }

    public String getItem() {
        return item;
    }

    public void setItem(String item) {
        this.item = item;
    }

    public double getAmount() {
        return amount;
    }

    public void setAmount(double amount) {
        this.amount = amount;
    }
}