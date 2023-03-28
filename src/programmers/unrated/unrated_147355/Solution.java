package programmers.unrated.unrated_147355;

class Solution {
    
    public int solution(String t, String p) {
        
        int length = p.length();
        int answer = 0;        
        for(int i=0; i<t.length()-length+1; i++){
            
            if(Long.parseLong(t.substring(i, i+length)) <= Long.parseLong(p)){
                answer++;
            }
        }
        return answer;
    }
    
}