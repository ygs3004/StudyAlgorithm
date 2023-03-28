package programmers.lv1.lv1_12921;

class Solution {
    
    public int solution(int n) {
        boolean[] number = new boolean[n+1];
        int answer = 0;
        
        for(int i=2; i<=n; i++){
            if(number[i]) continue;
            answer++;
            for(int j=i; j<=n; j+=i){
                if(number[j]) continue;
                number[j] = true;
            }
        }
        return answer;
    }
    
}