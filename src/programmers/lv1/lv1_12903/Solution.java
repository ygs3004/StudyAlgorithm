package programmers.lv1.lv1_12903;

class Solution {
    
    public String solution(String s) {
        
        String answer = "";
        String[] str = s.split("");
        int mid = s.length()/2;
            
        if(s.length()%2 == 0){
            answer = str[mid-1]+str[mid];
        }else{
            answer = str[mid];
        }
               
        return answer;
    }
    
}