package programmers.lv1.lv1_12931;

import java.util.*;

public class Solution {
    
    public int solution(int n) {
        
        int answer = 0;
        
        String[] number = String.valueOf(n).split("");
        for(String a : number){
            answer += Integer.parseInt(a);
        }

        return answer;
    }
    
}