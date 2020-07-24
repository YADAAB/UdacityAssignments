package com.udacity.jwdnd.whisperdemo;

public class ChatMessage {
    private String username;
    private String type;
    private String message;

    public ChatMessage(String username, String type, String message) {
        this.message = message;
        this.type = type;
        this.username = username;
    }

    public String getUsername() {
        return username;
    }

    public void setUsername(String username) {
        this.username = username;
    }

    public String getType() {
        return type;
    }

    public void setType(String type) {
        this.type = type;
    }

    public String getMessage() {
        return message;
    }

    public void setMessage(String message) {
        this.message = message;
    }



}
