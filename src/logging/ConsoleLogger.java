package logging;

public class ConsoleLogger extends AbstractLogger {

    @Override
    public void LogDebug(String message) {
        System.out.println("DEBUG: " + message);
    }

    @Override
    public void LogWarning(String message) {
        System.out.println("WARN: " + message);

    }

    @Override
    public void LogError(String message) {
        System.err.println("ERROR: " + message);
    }

    @Override
    public void LogUser(String message) {
        System.out.println(message);
    }
}
