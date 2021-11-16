package edu.eci.ieti.proyect.controller.websocket;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;
import org.springframework.stereotype.Service;

@Service
public class DataHashMap {
    
    private final Map<String, List<UserDataDto>> dataMap = new HashMap();
    private final Map<String, List<String>> dataMsg = new HashMap();
    
    public List<UserDataDto> getList(String key){
        return dataMap.get(key);
    }
    
    public void addUser(String key, UserDataDto user){
        if(dataMap.containsKey(key)){
            if(!dataMap.get(key).contains(user)){
                dataMap.get(key).add(user);
            }
        } else {
            List<UserDataDto> list = new ArrayList();
            list.add(user);
            dataMap.put(key, list);
        }
    }
    
    public void deleteUser(String key, UserDataDto user){
        
        dataMap.get(key).remove(user);
    }
    
    public List<String> getMsg(String key){
        return dataMsg.get(key);
    }
    
    public void addMsg(String key,String msg){
        if(dataMsg.containsKey(key)){
            dataMsg.get(key).add(msg);
        } else {
            ArrayList<String> list = new ArrayList();
            list.add(msg);
            dataMsg.put(key, list);
        }
    }
    
}