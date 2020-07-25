package com.udacity.jwdnd.whisperdemo;

public class ChatForm {
    private String username;
    private String type;
    private String message;

    public ChatForm(String username, String type, String message) {
        this.username = username;
        this.type = type;
        this.message = message;
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
