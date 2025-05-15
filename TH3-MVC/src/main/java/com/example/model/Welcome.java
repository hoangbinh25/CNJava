package com.example.model;

import java.time.LocalDateTime;

public class Welcome {
    private String message;
    private LocalDateTime time;

    public Welcome(String message, LocalDateTime time) {
        this.message = message;
        this.time = time;
    }

    public String getMessage() {
        return message;
    }

    public LocalDateTime getTime() {
        return time;
    }
}
