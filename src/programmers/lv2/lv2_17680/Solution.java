package programmers.lv2.lv2_17680;

import java.util.*;

class Solution {
    
    public int solution(int cacheSize, String[] cities) {
        
        int executeTime = 0;
        List<String> cache = new LinkedList<>();        
        for(String city : cities){
            city = city.toUpperCase();
            if(cache.contains(city)){
                cache.remove(city);
                cache.add(city); 
                executeTime += 1;
            }else{
                executeTime += 5;
                if(cacheSize == 0) continue;
                if(cache.size() >= cacheSize ){
                    cache.remove(0);
                }
                cache.add(city);  
            }
        }
        
        return executeTime;
    }
    
}