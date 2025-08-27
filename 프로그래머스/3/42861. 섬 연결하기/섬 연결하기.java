import java.util.*;

class Solution {
    public int solution(int n, int[][] costs) {
        
        List<Edge>[] graph = new List[n];
        for(int i = 0; i < n; i++){
            graph[i] = new ArrayList<>();
        }
        
        for(int[] cost : costs){
            int point1 = cost[0];
            int point2 = cost[1];
            int dist = cost[2];
            
            Edge edge1 = new Edge(point2, dist);
            Edge edge2 = new Edge(point1, dist);
            
            graph[point1].add(edge1);
            graph[point2].add(edge2);
        }
        
        boolean[] connected = new boolean[n];
        PriorityQueue<Edge> pq = new PriorityQueue<>();

        List<Edge> start = graph[0];
        start.forEach(edge -> {
            pq.add(edge);
        });
        
        connected[0] = true;
        int answer = 0;
        
        while(!pq.isEmpty()){
            Edge now = pq.poll();
            int to = now.to;
            int dist = now.dist;
            
            if(connected[to]) continue;
            connected[to] = true;
            answer += dist;
            List<Edge> nextEdges = graph[to];
            nextEdges.forEach(edge -> {
               if(!connected[edge.to]) {
                   pq.add(edge);
               }
            });
        }
        
        return answer;
    }
    
    private static class Edge implements Comparable<Edge>{
        int to;
        int dist;
        
        Edge(int to, int dist){
            this.to = to;
            this.dist = dist;
        }
        
        @Override
        public int compareTo(Edge o){
            return this.dist - o.dist;
        }
    }
}