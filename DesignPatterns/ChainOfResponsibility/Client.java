package DesignPatterns.ChainOfResponsibility;

public class Client {

    public static void main(String[] args) {

        LogHandler infoLogger = new InfoLogHandler();
        LogHandler debugLogger = new DebugLogHandler();
        LogHandler errorLogger = new ErrorLogHandler();

        infoLogger.setNextHandler(debugLogger);
        debugLogger.setNextHandler(errorLogger);

        infoLogger.logMessage("This is an info message.", LogLevel.INFO);
        infoLogger.logMessage("This is a debug message.", LogLevel.DEBUG);
        infoLogger.logMessage("This is an error message.", LogLevel.ERROR);
    }
}
