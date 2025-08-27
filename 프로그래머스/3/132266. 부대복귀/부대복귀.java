import java.util.*;

class Solution {
    
    public int[] solution(int n, int[][] roads, int[] sources, int destination) {
        
        List<Integer>[] graphs = new List[n + 1];
        for(int i = 1; i <= n; i++){
            graphs[i] = new ArrayList<>();
        }
        
        for(int[] road : roads){
            int p1 = road[0];
            int p2 = road[1];
            
            graphs[p1].add(p2);
            graphs[p2].add(p1);
        }
        
        boolean[] visited = new boolean[n + 1];
        int[] srcDist = new int[n + 1];
        Arrays.fill(srcDist, -1);
        
        Queue<int[]> que = new ArrayDeque<>();
        que.add(new int[]{destination, 0});
        
        while(!que.isEmpty()){
            int[] now = que.poll();    
            int point = now[0];
            int dist = now[1];
            if(visited[point]) continue;
            visited[point] = true;
            
            srcDist[point] = dist;
            int nextDist = dist + 1;
            List<Integer> nextGraph = graphs[point];
            nextGraph.forEach(nextPoint -> {
               if(!visited[nextPoint]) {
                   que.add(new int[]{nextPoint, nextDist});
               }
            });
        }
        
        int[] answer = new int[sources.length];
        
        for(int i = 0; i < answer.length; i++){
            answer[i] = srcDist[sources[i]];
        }
        
        return answer;
    }
    
}