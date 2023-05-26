package programmers.lv2.lv2_87390;


class Solution {
    public int[] solution(int n, long left, long right) {
        int now = 0;
        long nowIdx = (left-left%n);
        int ansIdx = 0;
        int answerLength = (int)(right-left)+1;
        int[] answer = new int[answerLength];
        
        outer:for(int i = (int)(left/n); i<n; i++){
            for(int j = 0; j<n; j++){
                now = Math.max(i+1, j+1);
                if(nowIdx>=left && nowIdx<=right){
                    answer[ansIdx++] = now;
                    if(nowIdx == right) break outer;
                }
                nowIdx++;
            }
        }
        return answer;
    }
    
}