package com.udacity.jwdnd.whisperdemo.model;

public class ChatMessage {

    private String username;
    private String message;
    private String type;
    private Integer messageid;



    public ChatMessage(Integer messageid, String username, String type, String message) {
        this.username = username;
        this.message = message;
        this.messageid = messageid;
        this.type = type;
    }

    public String getType() {
        return type;
    }

    public void setType(String type) {
        this.type = type;
    }


    public String getUsername() {
        return username;
    }

    public void setUsername(String username) {
        this.username = username;
    }
    public Integer getMessageid() {
        return messageid;
    }

    public void setMessageid(Integer messageid) {
        this.messageid = messageid;
    }



    public String getMessage() {
        return message;
    }

    public void setMessage(String message) {
        this.message = message;
    }

}
