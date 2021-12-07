package edu.eci.ieti.proyect.controller.websocket;

import com.google.gson.Gson;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.messaging.handler.annotation.DestinationVariable;
import org.springframework.messaging.handler.annotation.MessageMapping;
import org.springframework.messaging.simp.SimpMessagingTemplate;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.CrossOrigin;

@Controller
@CrossOrigin(origins="http://localhost:3000")
public class StompController {
    
    @Autowired
    SimpMessagingTemplate msgt;
    
    @MessageMapping("/university/chat/{name}")
    public void handleChatGroup(UserDataDto user, @DestinationVariable String name){
        Gson gson = new Gson();
        String json = gson.toJson(user);
        msgt.convertAndSend("/topic/university/chat/"+name, json);
    }
    
    @MessageMapping("/notification/{userId}")
    public void handleNotification(String userIdToAdd, @DestinationVariable String userId){
        System.out.println(userId);
        msgt.convertAndSend("/topic/notification/"+userId, userIdToAdd);
    }
}
