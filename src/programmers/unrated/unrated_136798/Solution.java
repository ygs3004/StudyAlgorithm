package programmers.unrated.unrated_136798;

class Solution {
    
    static int limit;
    static int power;
    
    public int solution(int number, int limit, int power) {
        int answer = 0;
        this.limit = limit;
        this.power = power;
        for(int i=1; i<=number; i++){
            answer += checkPower(i);
        }
        return answer;
    }
    
    public static int checkPower(int n){
        int count = 1;
        for(int i=1; i<=n/2; i++){
            if(n%i == 0) count++;
        }    
        return count > limit ? power : count ;
    }
    
}