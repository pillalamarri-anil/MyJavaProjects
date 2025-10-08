package DesignPatterns.ChainOfResponsibility;

public abstract class LogHandler {

    protected LogLevel level;

    protected LogHandler nextHandler;

    public void setNextHandler(LogHandler nextHandler)
    {
        this.nextHandler = nextHandler;
    }

    public abstract void logMessage(String message, LogLevel level);
}
