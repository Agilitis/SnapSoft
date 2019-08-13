package logging;

import java.util.logging.Logger;

public class LoggerFactory {

    public static AbstractLogger getLogger(LoggerTypes loggerType){
        if(loggerType == null) return null;

        if(loggerType == LoggerTypes.CONSOLE){
            return new ConsoleLogger();
        }
        return null;
    }

    private LoggerFactory(){};

}
