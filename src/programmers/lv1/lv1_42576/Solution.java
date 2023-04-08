package programmers.lv1.lv1_42576;

import java.util.*;
class Solution {
    public String solution(String[] participant, String[] completion) {
        
        Map<String, Integer> map = new HashMap<>();

        for(String name : participant){
            map.put(name, map.getOrDefault(name, 0)+1);
        }
        for(String name : completion){
            map.put(name, map.get(name)-1);
            
        }
        for(String name : participant){
            if(map.get(name) != 0) return name;
        }
        return "";
    }
    
}