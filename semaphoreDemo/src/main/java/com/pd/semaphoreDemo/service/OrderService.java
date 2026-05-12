package com.pd.semaphoreDemo.service;

import com.pd.semaphoreDemo.service.repo.OrderRepo;
import org.springframework.stereotype.Service;

import java.util.concurrent.Semaphore;
import java.util.concurrent.TimeUnit;

@Service
public class OrderService {
    private final OrderRepo orderRepo;

    private static Semaphore semaphore = new Semaphore(2);

    public OrderService(OrderRepo orderRepo) {
        this.orderRepo = orderRepo;
    }

    public String addOrder(Integer id) {

        try{
            boolean b = semaphore.tryAcquire(1, TimeUnit.SECONDS);
            if (b){
                String s = orderRepo.addOrder(id);
                semaphore.release();
                return s;
            }else {
            return "Db connection full";
            }
        }catch (Exception e){
        e.printStackTrace();
        return e.getMessage();
        }
    }
}
