import java.util.*;

class Solution {
    final int MAX_NODE = 20_000;
    
    public int solution(int n, int[][] edge) {
        List[] graphs = new List[MAX_NODE + 1];
        
        for(int[] info : edge){
            int node1 = info[0];
            int node2 = info[1];
            
            List<Integer> graph1 = getList(graphs, node1);
            List<Integer> graph2 = getList(graphs, node2);
            
            graph1.add(node2);
            graph2.add(node1);
        }
        
        Queue<NodeDist> queue = new ArrayDeque<>();
        boolean[] visited = new boolean[MAX_NODE + 1];
        queue.add(new NodeDist(1, 0));
        
        int maxDist = 0;
        int answer = 0;
        
        while(!queue.isEmpty()){
            NodeDist now = queue.poll();
            int node = now.node;
            int dist = now.dist;
            
            if(visited[node]) continue;
            visited[node] = true;
        
            if(dist > maxDist){
                maxDist = dist;
                answer = 1;
            }else if(dist == maxDist){
                answer++;
            }
            
            List<Integer> graph = graphs[node];
            if(graph == null) continue;
            
            graph.forEach(nextNode -> queue.add(new NodeDist(nextNode, dist + 1)));
        }
        

        return answer;
    }
    
    private List getList(List[] graphs, int node){
        
        if(graphs[node] == null) {
            graphs[node] = new ArrayList<>();
        }
        
        return graphs[node];   
    }
    
    private static class NodeDist{
        int node;
        int dist;
        
        NodeDist(int node, int dist){
            this.node = node;
            this.dist = dist;
        }
    }
}