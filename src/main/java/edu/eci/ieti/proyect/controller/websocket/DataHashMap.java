package edu.eci.ieti.proyect.controller.websocket;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;
import org.springframework.stereotype.Service;

@Service
public class DataHashMap {
    
    private final Map<String, List<UserDataDto>> dataMap = new HashMap();
    
    public List<UserDataDto> getList(String key){
        return dataMap.get(key);
    }
    
    public void addUser(String key, UserDataDto user){
        if(dataMap.containsKey(key)){
            dataMap.get(key).add(user);
        } else {
            List<UserDataDto> list = new ArrayList();
            list.add(user);
            dataMap.put(key, list);
        }
    }
}


