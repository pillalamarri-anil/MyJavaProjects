package DesignPatterns.ChainOfResponsibility;

public class ErrorLogHandler extends LogHandler{

    ErrorLogHandler() {
        this.level = LogLevel.ERROR;
    }

    @Override
    public void logMessage(String message, LogLevel level) {
        if(this.level == level) {
            System.out.println("ERROR: " + message);
        } else if (nextHandler != null) {
            nextHandler.logMessage(message, level);
        }
    }
}
