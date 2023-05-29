package com.testingsostenible.curso;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;

public class Console {
    Logger logger = LoggerFactory.getLogger(Console.class);

    public void log (String message) {
        logger.info(message);
    }
}
