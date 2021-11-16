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
    
    @Autowired
    DataHashMap dataHashMap;
    
    @MessageMapping("/university/{name}")
    public void handleuniversity(UserDataDto user, @DestinationVariable String name){
        dataHashMap.addUser(name, user);
        Gson gson = new Gson();
        String json = gson.toJson(dataHashMap.getList(name));
        msgt.convertAndSend("/topic/university/"+name, json);
    }
    
    @MessageMapping("/disconnet/{name}")
    public void handleDisconnect(UserDataDto user, @DestinationVariable String name){
        dataHashMap.deleteUser(name, user);
        Gson gson = new Gson();
        String json = gson.toJson(dataHashMap.getList(name));
        msgt.convertAndSend("/topic/university/"+name, json);
    }
    
    @MessageMapping("/university/chat/{name}")
    public void handleChatGroup(String msg, @DestinationVariable String name){
        dataHashMap.addMsg(name, msg);
        Gson gson = new Gson();
        String json = gson.toJson(dataHashMap.getMsg(name));
        msgt.convertAndSend("/topic/university/chat/"+name, json);
    }
}
