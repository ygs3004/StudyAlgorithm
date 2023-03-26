package programmers.lv1.lv1_12917;

import java.util.*;

class Solution {
    public String solution(String s) {
        String[] sArr = s.split("");
        Arrays.sort(sArr);
        
        StringBuilder sb = new StringBuilder();
        
        for(int i=sArr.length-1; i>=0; i--){
            sb.append(sArr[i]);
        }
        
        return sb.toString();
    }
    
}