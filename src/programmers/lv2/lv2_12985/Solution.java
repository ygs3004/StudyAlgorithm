package programmers.lv2.lv2_12985;

class Solution{
    public int solution(int n, int a, int b){
        int answer = 0;
        while(a!=b){
            answer++;
            a = nextRoundNumber(n, a);
            b = nextRoundNumber(n, b);
        }
        return answer;
    }
    
    static int nextRoundNumber(int n, int a){
        return (a+1)/2;
    }
}