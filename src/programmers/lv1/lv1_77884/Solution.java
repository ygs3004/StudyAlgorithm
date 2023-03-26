package programmers.lv1.lv1_77884;

class Solution {
    
    public int solution(int left, int right) {
        int answer = 0;
        for(int i=left; i<=right; i++){
            answer += divideNum(i)%2 == 0 ? i : -i; 
        }
        return answer;
    }
    
    static int divideNum(int a){
        int ret = 0;
        for(int i=1; i<=a; i++){
            if(a%i == 0) ret++;
        }
        return ret;
    }
}