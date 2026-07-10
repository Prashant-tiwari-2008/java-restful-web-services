package com.javaStudy.rest_web_services.restful_web_services.exception;

import java.time.LocalDateTime;

public class ErrorDetails {
    private final LocalDateTime timestamp;
    private final String message;
    private final String description;

    public ErrorDetails(LocalDateTime now, String message, String description) {
        this.timestamp = now;
        this.message = message;
        this.description = description;
    }

    public LocalDateTime getTimestamp() {
        return timestamp;
    }

    public String getMessage() {
        return message;
    }

    public String getDescription() {
        return description;
    }


}
