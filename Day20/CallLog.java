package com.Day20;
import java.time.*;

public class CallLog {
    private String caller;
    private String receiver;
    private LocalDateTime startTime;
    private LocalDateTime endTime;

    public CallLog(String caller, String receiver, LocalDateTime startTime, LocalDateTime endTime) {
        this.caller = caller;
        this.receiver = receiver;
        this.startTime = startTime;
        this.endTime = endTime;
    }

    public long getDurationInMinutes() {
        return Duration.between(startTime, endTime).toMinutes();
    }

    public String getCaller() {
        return caller;
    }

    public String getReceiver() {
        return receiver;
    }

    public LocalDateTime getStartTime() {
        return startTime;
    }

    public LocalDateTime getEndTime() {
        return endTime;
    }
}

