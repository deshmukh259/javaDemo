package com;


import org.slf4j.Logger;
import org.slf4j.LoggerFactory;

import ch.qos.logback.classic.Level;

public class Loggerrr {

    public static void main(String[] args) {

        Logger logger = LoggerFactory.getLogger(Loggerrr.class);

        logger.info("Sample Info");
        logger.debug("Sample Debug");
        logger.error("Sample Error");
        logger.trace("Sample Trace");
        logger.warn("Sample Warn");

        System.out.println("------------");
/*
        set(Level.ERROR);

        logger.info("Sample Info After setLevel");
        logger.debug("Sample Debug After setLevel");
        logger.error("Sample Error After setLevel");
        logger.trace("Sample Trace After setLevel");
        logger.warn("Sample Warn After setLevel");
*/


        set(Level.fromLocationAwareLoggerInteger(20));
        System.out.println("-----------");
        logger.info("Sample Info After setLevel");
        logger.debug("Sample Debug After setLevel");
        logger.error("Sample Error After setLevel");
        logger.trace("Sample Trace After setLevel");
        logger.warn("Sample Warn After setLevel");


    }

    private static void set(Level error) {
        ch.qos.logback.classic.Logger logger2 = (ch.qos.logback.classic.Logger) LoggerFactory.getLogger("com");
        logger2.setLevel(error);
    }
}
