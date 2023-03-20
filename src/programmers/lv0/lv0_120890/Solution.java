package programmers.lv0.lv0_120890;

class Solution {
    public int solution(int[] array, int n) {
        
        int answer = Integer.MAX_VALUE;
        int diff = Integer.MAX_VALUE;
        
        for(int i : array){
            int newDiff = Math.abs(i-n);
            if(diff >= newDiff){
                if(diff == newDiff){
                    answer = answer < i ? answer : i;
                }else{
                    diff = newDiff;    
                    answer = i;
                }
            }
        }
        return answer;
    }
}