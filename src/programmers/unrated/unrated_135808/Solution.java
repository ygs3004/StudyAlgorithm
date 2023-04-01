package programmers.unrated.unrated_135808;

import java.util.*;

class Solution {
    
    public int solution(int k, int m, int[] score) {
        Arrays.sort(score);
        int[] sortScore = new int[score.length];
        for(int i=0; i<score.length; i++){
            sortScore[i] = score[score.length-1-i];
        }
        
        int result = 0;
        for(int i=0; i+m-1<sortScore.length; i = i+m){
            result += sortScore[i+m-1] * m;
        }
        
        return result;
    }
    
}