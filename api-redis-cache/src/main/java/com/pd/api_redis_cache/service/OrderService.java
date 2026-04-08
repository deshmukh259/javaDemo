package com.pd.api_redis_cache.service;

import com.pd.api_redis_cache.service.model.Order;
import com.pd.api_redis_cache.service.repository.OrderRepository;
import lombok.extern.slf4j.Slf4j;
import org.springframework.data.redis.core.RedisTemplate;
import org.springframework.data.redis.core.ValueOperations;
import org.springframework.stereotype.Service;
import tools.jackson.databind.ObjectMapper;

import java.util.Optional;

@Service
@Slf4j
public class OrderService {


    private final OrderRepository orderRepository;
    private final RedisTemplate<String, Object> redisTemplate;

    public OrderService(OrderRepository orderRepository, RedisTemplate<String, Object> redisTemplate) {
        this.orderRepository = orderRepository;
        this.redisTemplate = redisTemplate;
    }

    public boolean tryLock(Integer id) {
        return orderRepository.tryLock(id);
    }

    public void lock(Integer id) {
      orderRepository.lock(id);
    }

    public boolean releaseLock(Integer id) {
        return orderRepository.relaseLock(id);
    }

    public Order getOrder(Integer id) {

        try {
            ObjectMapper om = new ObjectMapper();
            System.out.println("get Key " + id);
            ValueOperations<String, Object> stringObjectValueOperations = redisTemplate.opsForValue();
            Object o = stringObjectValueOperations.get(String.valueOf(id));
            System.out.println("--retruned value \n " + o);
            if (o == null) {
                if (tryLock(id)) {
                    lock(id);
                    Optional<Order> byId = orderRepository.findByIdo(id);
                    redisTemplate.opsForValue().set(String.valueOf(id), byId.get());
                    releaseLock(id);
                    // notify all
                    return byId.get();
                } else {
                    System.out.println("locked---");
                }


            }else{
                return om.readValue((String) o,Order.class);
            }

        } catch (Exception e) {
            throw e;
        }
        return null;
    }
}
