package programmers.lv1.lv1_118666;

import java.util.*;
class Solution {
    public String solution(String[] survey, int[] choices) {
        // R vs T
        // C vs F
        // J vs M
        // A vs N
        int[] scoreArr = {0, 3, 2, 1, 0, 1, 2, 3};
        
        Map<String, Integer> map = new HashMap<>();
        
        for(int i=0; i<survey.length; i++){
            String type = "";
            int score = 0;
            if(choices[i]<4){
                type = String.valueOf(survey[i].charAt(0));
            }else if(choices[i]>4){
                type = String.valueOf(survey[i].charAt(1));
            }
            score = map.getOrDefault(type, 0);
            score += scoreArr[choices[i]];
            map.put(type, score);
        }
        
        String answer = "";
        answer += map.getOrDefault("R", 0) >= map.getOrDefault("T" ,0) ? "R" : "T";
        answer += map.getOrDefault("C", 0) >= map.getOrDefault("F", 0) ? "C" : "F";
        answer += map.getOrDefault("J", 0) >= map.getOrDefault("M", 0) ? "J" : "M";
        answer += map.getOrDefault("A", 0) >= map.getOrDefault("N", 0) ? "A" : "N";
        
        return answer;
    }
}