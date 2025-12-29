package com.pd.api_redis_cache.service;

import com.pd.api_redis_cache.service.repository.OrderRepository;
import lombok.extern.slf4j.Slf4j;
import org.springframework.data.redis.core.RedisTemplate;
import org.springframework.data.redis.core.ValueOperations;
import org.springframework.stereotype.Service;

@Service
@Slf4j
public class OrderService {


    private final OrderRepository orderRepository;
    private final RedisTemplate<String, Object> redisTemplate;

    public OrderService(OrderRepository orderRepository, RedisTemplate<String, Object> redisTemplate) {
        this.orderRepository = orderRepository;
        this.redisTemplate = redisTemplate;
    }
    public boolean tryLock(Integer id){
return false;
    }
    public void lock(Integer id){

    }
    public boolean releaseLock(Integer id){
return false;
    }
    public void getOrder(Integer id) {

        try{
            System.out.println("get Key "+id);
            ValueOperations<String, Object> stringObjectValueOperations = redisTemplate.opsForValue();
            Object o = stringObjectValueOperations.get(id);
            System.out.println("--retruned value \n "+o);

        }catch (Exception e){
            throw e;
        }
    }
}
