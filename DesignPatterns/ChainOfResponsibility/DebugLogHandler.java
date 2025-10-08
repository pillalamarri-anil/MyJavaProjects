package DesignPatterns.ChainOfResponsibility;

public class DebugLogHandler extends LogHandler {

    DebugLogHandler() {
        this.level = LogLevel.DEBUG;
    }

    @Override
    public void logMessage(String message, LogLevel level) {
        if(this.level == level) {
            System.out.println("DEBUG: " + message);
        } else if (nextHandler != null) {
            nextHandler.logMessage(message, level);
        }
    }
}
