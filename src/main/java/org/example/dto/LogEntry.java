package org.example.dto;

public class LogEntry {
    private String timestamp;
    private String level;
    private String message;

    public LogEntry() {}
    public LogEntry(String timestamp, String level, String message) {
        this.timestamp = timestamp; this.level = level; this.message = message;
    }
    public String getTimestamp() { return timestamp; }
    public String getLevel() { return level; }
    public String getMessage() { return message; }
    public void setTimestamp(String timestamp) { this.timestamp = timestamp; }
    public void setLevel(String level) { this.level = level; }
    public void setMessage(String message) { this.message = message; }
}
