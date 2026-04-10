package com.pd.api_redis_cache;

import com.pd.api_redis_cache.service.OrderService;
import com.pd.api_redis_cache.service.model.Order;
import org.aspectj.weaver.ast.Or;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RestController;

@RestController("/api/v1")
public class ApiClass {



    private final OrderService orderService;

    public ApiClass(OrderService orderService) {
        this.orderService = orderService;
    }

    @GetMapping(value = "/order/{id}")
    public Order getOrder(@PathVariable Integer id){

       return orderService.getOrder(id);
    }
}
