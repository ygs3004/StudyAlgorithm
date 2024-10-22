import java.util.*;

class Solution {
    boolean[] visited;
    
    public int solution(int[] cards) {
        
        visited = new boolean[cards.length];
        PriorityQueue<Integer> pq = new PriorityQueue<>((a, b) -> b - a);
        
        for(int i = 0; i < visited.length; i++){
            if(visited[i]) continue;
            visited[i] = true;
            int next = cards[i] - 1;
            int boxSize = 1;
            while(!visited[next]){
                visited[next] = true;
                next = cards[next] - 1;
                boxSize++;
            }
            pq.add(boxSize);
        }
        
        int answer = 0;
        if(pq.size() > 1){
            answer = pq.poll() * pq.poll();
        }
        
        return answer;
    }
}