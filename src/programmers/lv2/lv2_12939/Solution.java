package programmers.lv2.lv2_12939;

import java.util.*;
class Solution {
    public String solution(String s) {
        
        Answer answer = new Answer(Integer.MAX_VALUE, Integer.MIN_VALUE);
        
        Arrays.stream(s.split(" ")).forEach( v -> {
            answer.setMax(Integer.parseInt(v));
            answer.setMin(Integer.parseInt(v));
        });
        
        return answer.toString();
    }
    
    class Answer{
        int max;
        int min;
        
        Answer(int min, int max){
            this.max = max;
            this.min = min;
        }
        
        public void setMax(int n){
            max = Math.max(this.max, n);
        }
        public void setMin(int n){
            min = Math.min(this.min, n);
        }
        
        public String toString(){
            return min + " " + max;
        }
    }
}