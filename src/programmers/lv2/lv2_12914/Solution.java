package programmers.lv2.lv2_12914;

class Solution {
    public long solution(int n) {
        int[] answer = new int[n+1];
        if(n==1) return 1;
        else if(n==2) return 2;
        answer[1] = 1;
        answer[2] = 2;        
        for(int i=3; i<=n; i++){
            answer[i] = (answer[i-1]%1234567 + answer[i-2]%1234567)%1234567;
        }
        
        return answer[n];
    }
}