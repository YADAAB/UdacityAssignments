package com.udacity.jwdnd.whisperdemo.controller;

import com.udacity.jwdnd.whisperdemo.model.ChatForm;
import com.udacity.jwdnd.whisperdemo.service.ChatService;
import org.springframework.security.core.Authentication;
import org.springframework.security.core.context.SecurityContextHolder;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.PostMapping;

import java.security.Certificate;

@Controller
public class ChatController {
    private ChatService chatservice;
    private Authentication auth;

    public ChatController(ChatService chatservice) {
        System.out.println("Chat Controller Init..");
        this.chatservice = chatservice;
        //this.auth = SecurityContextHolder.getContext().getAuthentication();
    }

    @GetMapping("/chat")
    public String getChat(Authentication auth, @ModelAttribute("chatform") ChatForm cm, Model model)
    {
        System.out.println("Auth user "+this.chatservice.getMessages((String) auth.getPrincipal()));
        model.addAttribute("chatexpr", this.chatservice.getMessages((String) auth.getPrincipal()));
        return "chat";
    }


    @PostMapping("/chat")
    public String addChat(Authentication auth, @ModelAttribute("chatform") ChatForm cm, Model model)
    {
        System.out.println("auth.name() "+auth.getName());
        chatservice.addMessage((String) auth.getName(), cm.getType(), cm.getMessage());
        model.addAttribute("chatexpr", this.chatservice.getMessages((String) auth.getName()));
        cm.setMessage(""); //cm.setType("");
        return "chat";
    }

}
