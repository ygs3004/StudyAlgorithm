import java.util.*;

class Solution {
    
    final int INFECT = 0;
    Map<Integer, int[]> graphs;
    int answer;
    
    public int solution(int n, int infection, int[][] edges, int k) {
        this.graphs = new HashMap<>();
        
        int[] unionNodes = new int[n + 1];
        for(int i = 1; i <= n; i++){
            unionNodes[i] = i;
        }
        
        for(int i = 1; i <= 3; i++){
            int[] nodes = Arrays.copyOf(unionNodes, unionNodes.length);
            graphs.put(i, nodes);
        }
        
        for(int[] edge: edges){
            int[] nodes = graphs.get(edge[2]);
            int node1 = edge[0];
            int node2 = edge[1];
            
            union(nodes, node1, node2);
        }
        
        this.answer = 0;
        for(int i = 1; i<= 3; i++){
            int[] nodes = Arrays.copyOf(unionNodes, unionNodes.length);
            nodes[infection] = INFECT;
            dfs(i, nodes, 1, k);
        }
        
        return answer;
    }
    
    private void dfs(int type, int[] nodes, int depth, int target){
        int[] nextNodes = Arrays.copyOf(nodes, nodes.length);
        int[] graph = graphs.get(type);
        
        for(int i = 1; i < nextNodes.length; i++){
            if(nodes[i] != INFECT) continue;
            
            int connect = find(graph, i);
            for(int j = 1; j < nextNodes.length; j++){
                if(find(graph, j) == connect){
                    nextNodes[j] = INFECT;
                }
            }
        }
        
        if(target == depth){
            int cnt = 0;
            for(int i = 1; i < nextNodes.length; i++){
                if(nextNodes[i] == INFECT) cnt++;
            }
            answer = Math.max(cnt, answer);
            return;
        }
        
        for(int i = 1; i <=3; i++){
            // if(i == type) continue;
            dfs(i, nextNodes, depth + 1, target);
        }
    }
    
    private boolean union(int[] parent, int node1, int node2){
        int p1 = find(parent, node1);
        int p2 = find(parent, node2);
        
        if(p1 == p2) return false;
        
        if(p1 < p2){
            parent[p2] = p1;
        }else{
            parent[p1] = p2;
        }
        
        
        return true;
    }
    
    private int find(int[] parent, int node){
        if(parent[node] == node){
            return node;
        }
        
        return parent[node] = find(parent, parent[node]);
    }
    

}