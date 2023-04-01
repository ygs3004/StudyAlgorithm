package programmers.unrated.unrated_138477;

import java.util.*;

class Solution {
    
    public int[] solution(int k, int[] scores) {
        
        PriorityQueue<Integer> queue = new PriorityQueue<>();
        
        int[] answer = new int[scores.length];
        int minScore = Integer.MAX_VALUE;
        int idx = 0;
        
        for(int score : scores){
            if(queue.size()<k){
                queue.add(score);
                minScore = Math.min(minScore, score);
                answer[idx++] = minScore;
            }else if(queue.peek()<score){
                queue.poll();
                queue.add(score);
                minScore = queue.peek();
                answer[idx++] = minScore;
            }else{
                answer[idx++] = minScore;
            }
        }

        return answer;
    }
    
}