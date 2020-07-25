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
    public String getChat(@ModelAttribute("chatform") ChatForm cm, Model model)
    {

        model.addAttribute("chatexpr", this.chatservice.getMessages());
        return "chat";
    }


    @PostMapping("/chat")
    public String addChat(@ModelAttribute("chatform") ChatForm cm, Model model)
    {
        chatservice.addMessage(cm.getUsername(), cm.getType(), cm.getMessage());
        model.addAttribute("chatexpr", this.chatservice.getMessages());
        cm.setUsername("");
        cm.setMessage("");
        cm.setType("");
        return "chat";
    }

}
