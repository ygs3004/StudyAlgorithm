package programmers.lv1.lv1_76501;

class Solution {
    
    public int solution(int[] absolutes, boolean[] signs) {
        
        int answer = 0;
        
        for(int i=0; i<absolutes.length; i++){
            answer += signs[i] ? absolutes[i] : -absolutes[i];
        }
       
        return answer;
    }
    
}