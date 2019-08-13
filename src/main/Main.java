package main;

import logging.LoggerFactory;
import logging.LoggerTypes;

public class Main {

    public static void main(String[] args) {
        var logger = LoggerFactory.getLogger(LoggerTypes.CONSOLE);
        logger.LogDebug("Hello World!");
    }
}
