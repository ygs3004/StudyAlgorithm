package programmers.lv1.lv1_12903;

class Solution {
    
    public String solution(String s) {
        String[] str = s.split("");
        return s.length()%2 == 0 ? str[s.length()/2-1]+ str[s.length()/2] : str[s.length()/2];
    }
    
}