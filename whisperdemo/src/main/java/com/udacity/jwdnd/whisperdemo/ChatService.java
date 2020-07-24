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
        list.add(new ChatMessage(username, type, message));
    }

    public List<ChatMessage> getMessages()
    {
        return list;
    }

    @PostConstruct
    public void postConstruct() {
        this.list = new ArrayList();

    }



}

