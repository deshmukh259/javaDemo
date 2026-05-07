package com.pd.semaphoreDemo.service.repo;


import org.springframework.stereotype.Component;

import java.util.ArrayList;
import java.util.List;

@Component
public class OrderRepo {

    private static final List<Integer> repoList = new ArrayList();
    public String addOrder(Integer id) throws InterruptedException {

        repoList.add(id);
        Thread.sleep(3000000);
        return "Order created "+id;


    }


    public List getLi(){
        return repoList;
    }
}
