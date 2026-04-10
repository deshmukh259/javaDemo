package com.pd.CacheDemo;

import org.springframework.cache.annotation.CacheEvict;
import org.springframework.cache.annotation.Cacheable;
import org.springframework.scheduling.annotation.Scheduled;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.random.RandomGenerator;

@Service
public class ItemService {

    @Cacheable("items")
    public List<Item> getItems() {

        return getI();

    }


    public List<Item> getI(){

        System.out.println("----Getting New Item list");
        RandomGenerator aDefault = RandomGenerator.getDefault();
        int i = aDefault.nextInt();

        return List.of(new Item(i),new Item(aDefault.nextInt()),new Item(aDefault.nextInt()),new Item(aDefault.nextInt()));
    }

    @Scheduled(cron = "0 0/1 * * * *") // every 5 minutes at 0 seconds
    @CacheEvict(value = "items", allEntries = true)
    public void evictAndRebuildUsersCache() {
        System.out.println("true = do nothing clear cache" );
    }
}
