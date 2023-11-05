package com.smhrd.bridge.controller;

import org.springframework.messaging.handler.annotation.MessageMapping;
import org.springframework.messaging.handler.annotation.SendTo;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.CrossOrigin;
import org.springframework.web.bind.annotation.RequestMapping;

import com.smhrd.bridge.entity.ChatMessage;

@Controller
@CrossOrigin("*")
@RequestMapping("/websocket")
public class ChatController {
    @MessageMapping("/chat.sendMessage")
    @SendTo("/topic/public")
    public ChatMessage sendMessage(ChatMessage chatMessage) {
        return chatMessage;
    }

    @MessageMapping("/chat.addUser")
    @SendTo("/topic/public")
    public ChatMessage addUser(ChatMessage chatMessage) {
        return chatMessage;
    }
    
    @MessageMapping("/chat.requestHelp")
    @SendTo("/topic/helpResponse")
    public String requestHelp(String user_name) {
        return user_name;
    }
    
    @MessageMapping("/chat.teacherLive")
    @SendTo("/topic/liveResponse")
    public String teacherLive(String teacherLive) {
    	return teacherLive;
    }

}