package com.example.junitMore;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;

import java.util.HashMap;
import java.util.Map;

@Configuration
public class Config {

    Logger logger = LoggerFactory.getLogger(getClass());

    @Bean
    public Map<String, String> getMp() {
        return new HashMap<>();
    }

    record SlowBean() {

    }

    @Bean
    public SlowBean getSlowBean() throws InterruptedException {
        logger.info("slowwwwww");
       // Thread.sleep(3000);
        logger.info("init");
        //Thread.sleep(3000);
        logger.info("config");
       // Thread.sleep(3000);
        logger.info("DOneee");
        return new SlowBean();
    }
}
