package com.udacity.jwdnd.whisperdemo;

import org.springframework.stereotype.Service;

import javax.annotation.PostConstruct;
import java.util.ArrayList;
import java.util.List;

@Service
public class ChatService {

    private List<ChatMessage> list;

    public void addMessage( String username, String type, String message)
    {
        ChatMessage cmsg = new ChatMessage();
        cmsg.setUsername(username);
        switch (type) {
            case "say":
                cmsg.setMessage(message);
                break;
            case "shout":
                cmsg.setMessage(message.toUpperCase());
                break;
            case "whisper":
                cmsg.setMessage(message.toLowerCase());
                break;
        }
        //System.out.println(cmsg.getUsername());
        //System.out.println(cmsg.getMessage());
        this.list.add(cmsg);
    }

    public List<ChatMessage> getMessages()
    {
        return this.list;
    }

    @PostConstruct
    public void postConstruct() {
        this.list = new ArrayList();

    }



}

