package DesignPatterns.ChainOfResponsibility;

public class InfoLogHandler extends LogHandler {

    public InfoLogHandler() {
        this.level = LogLevel.INFO;
    }

    @Override
    public void logMessage(String message, LogLevel level) {

        if (level == LogLevel.INFO) {
            System.out.println("INFO: " + message);
        } else if (nextHandler != null) {
            nextHandler.logMessage(message, level);
        }
    }


}
