import java.util.*;

class Solution {
    
    public int solution(int[] scoville, int K) {
        PriorityQueue<Integer> queue = new PriorityQueue();
        for(int scovile : scoville){
            queue.add(scovile);
        }
       
        int answer = 0;
        while(queue.size() >= 2 && queue.peek() < K){
            answer++;
            int newScoville = queue.poll() + (queue.poll()*2);
            queue.add(newScoville);
        }

        return queue.peek() < K ? -1 : answer;
    }
    
}