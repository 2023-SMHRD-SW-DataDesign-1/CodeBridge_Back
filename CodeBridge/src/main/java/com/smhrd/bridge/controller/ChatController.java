package com.smhrd.bridge.controller;

import org.springframework.messaging.handler.annotation.MessageMapping;
import org.springframework.messaging.handler.annotation.SendTo;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.CrossOrigin;
import org.springframework.web.bind.annotation.RequestMapping;

import com.smhrd.bridge.entity.ChatMessage;

@Controller
@CrossOrigin(origins = "http://localhost:8085")
@RequestMapping("/websocket")
public class ChatController {
    @MessageMapping("/chat.sendMessage")
    @SendTo("/topic/public")
    public ChatMessage sendMessage(ChatMessage chatMessage) {
    	System.out.println("컨트롤 들어옴"+chatMessage);
        return chatMessage;
    }

    @MessageMapping("/chat.addUser")
    @SendTo("/topic/public")
    public ChatMessage addUser(ChatMessage chatMessage) {
    	System.out.println("컨트롤");
        return chatMessage;
    }
    
    @MessageMapping("/chat.requestHelp")
    @SendTo("/topic/helpResponse")
    public String requestHelp(String user_name) {
        System.out.println("도움요청이 들어왔습니다. 이름: " + user_name);
        return user_name;
    }

}