package programmers.lv1.lv1_12901;

import java.util.*;

class Solution {
    
    public String solution(int a, int b) {
        
        Map<Integer, String> map = new HashMap<>();
        map.put(0, "SUN");
        map.put(1, "MON");
        map.put(2, "TUE");
        map.put(3, "WED");
        map.put(4, "THU");
        map.put(5, "FRI");
        map.put(6, "SAT");
        
        String someDay = "2016/"+a+"/"+b;
        
        Date date = new Date(someDay);
        
        return map.get(date.getDay());
    }
    
}