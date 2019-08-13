package logging;

public abstract class AbstractLogger {

    public abstract void LogDebug(String message);
    public abstract void LogWarning(String message);
    public abstract void LogError(String message);
}
