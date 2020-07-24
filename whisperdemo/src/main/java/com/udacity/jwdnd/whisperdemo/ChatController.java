package com.udacity.jwdnd.whisperdemo;

import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.PostMapping;

@Controller
public class ChatController {
    private ChatService chatservice;

    public ChatController(ChatService chatservice) {
        this.chatservice = chatservice;

    }

    @GetMapping("/chat")
    public String getChat(@ModelAttribute("chatmessage") ChatMessage cm, Model model)
    {
        model.addAttribute("chatmessage", chatservice.getMessages());
        return "chat";
    }


    @PostMapping("/chat")
    public String addChat(@ModelAttribute("chatmessage") ChatMessage cm, Model model)
    {
        chatservice.addMessage(cm.getType(),cm.getUsername(), cm.getMessage());
        model.addAttribute("chatmessage", chatservice.getMessages());
        cm.setMessage("");
        cm.setType("");
        cm.setUsername("");
        return "chat";
    }

}
