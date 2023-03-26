package programmers.lv1.lv1_12943;

class Solution {
    public int solution(long num) {
        int answer = 0;
        
        if(num == 1) return 0;
        
        for(int i=0; i<500; i++){
            num = collatz(num);
            answer++;
            if(num == 1) break;
            if(answer == 500) return -1;
        }
        
        return answer;
    }
    
    static long collatz(long a){
        return a%2==0 ? a/2 : a*3+1;
    }
}