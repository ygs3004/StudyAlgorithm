package programmers.lv1.lv1_12919;

import java.util.Arrays;

class Solution {
    
    public String solution(String[] seoul) {
        
        int[] idx = {0, 0};
        
        Arrays.stream(seoul).forEach( v -> {
            if(v.equals("Kim")) idx[1] = idx[0];
            idx[0]++;
        });
        
        return "김서방은 "+idx[1]+"에 있다";
    }
    
}