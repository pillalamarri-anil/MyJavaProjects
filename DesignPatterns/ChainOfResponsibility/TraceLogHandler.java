package DesignPatterns.ChainOfResponsibility;

public class TraceLogHandler extends LogHandler{

    public TraceLogHandler() {
        this.level = LogLevel.TRACE;
    }

    @Override
    public void logMessage(String message, LogLevel level) {
        if(this.level == level) {
            System.out.println("TRACE: " + message);
        } else if (nextHandler != null) {
            nextHandler.logMessage(message, level);
        }
    }
}
