package programmers.unrated.unrated_132267;

class Solution {
    
    public int solution(int emptyC, int newC, int n) {
        
        int answer = 0;
        
        while(n>=emptyC){
            n -= emptyC;
            n += newC;
            answer += newC;
        }
        
        return answer;
        
    }
    
}