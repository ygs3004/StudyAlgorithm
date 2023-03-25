package programmers.lv1.lv1_12928;

class Solution {
    
    public int solution(int n) {
        
        int answer = 0;
        
        for(int i=1; i<=n; i++){
            answer = n%i==0 ? answer + i : answer;
        }
        
        return answer;
    }
    
}