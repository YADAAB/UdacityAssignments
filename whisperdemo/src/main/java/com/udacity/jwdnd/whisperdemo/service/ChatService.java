package com.udacity.jwdnd.whisperdemo.service;

import com.udacity.jwdnd.whisperdemo.DBmapper.MessageMapper;
import com.udacity.jwdnd.whisperdemo.model.ChatMessage;
import com.udacity.jwdnd.whisperdemo.model.User;
import org.springframework.stereotype.Service;
//import static org.junit.jupiter.api.Assertions.assertArrayEm;
import javax.annotation.PostConstruct;
import java.util.ArrayList;
import java.util.List;

@Service
public class ChatService {

    private List<ChatMessage> list;

    public ChatService(MessageMapper messagemapper) {
        System.out.println("ChatService Init..");
        this.messagemapper = messagemapper;
    }

    private MessageMapper messagemapper;
    private Integer res;
    public void addMessage( String username, String type, String message)
    {
        System.out.println("addMessage Chat Service "+username);
        System.out.println("addMessage Chat Service "+message);
        res = messagemapper.insert(new ChatMessage(null, username, type, message));
        if (res > 0) {
        System.out.println("Inserted message "+message);
        }
        }


    public List<ChatMessage> getMessages(String username)
    {
        //use getChatMessage() in MessageMapper to get data for user
        return messagemapper.getChatMessage(username);
    }

    @PostConstruct
    public void postConstruct() {
        //this.list = new ArrayList();
        System.out.println("creating ChatService Bean");

    }



}

