import java.util.*;

class Solution {
    
    Edge[] edgeArr;
    
    public int[] solution(int[][] edges) {

        edgeArr = new Edge[1_000_001];
        
        for(int i = 0; i < edges.length; i++){
            int[] edgeInfo = edges[i];
            int edgeNum1 = edgeInfo[0];
            int edgeNum2 = edgeInfo[1];
            Edge edge1 = getEdge(edgeNum1);
            Edge edge2 = getEdge(edgeNum2);
            
            edge1.toCount++;
            edge1.graph.add(edge2);
            edge2.fromCount++;
        }
        
        int centerEdgeNum = findCenterEdgeNum();
        Edge centerEdge = getEdge(centerEdgeNum);

        for(Edge connectCenterEdge : centerEdge.graph){
            connectCenterEdge.fromCount--;
        }
        
        int donut = 0;
        int bar = 0;
        int twist = 0;
        int total = centerEdge.graph.size();
        for(int i = 0; i < edgeArr.length; i++){
            if(i == centerEdgeNum) continue;
            
            if(edgeArr[i] != null && edgeArr[i].fromCount == 2){
                twist++;
            }else if(edgeArr[i] != null && edgeArr[i].fromCount == 0){
                bar++;
            }
        }
        
        donut = total - twist - bar;

        return new int[]{centerEdgeNum, donut, bar, twist};
    }
    
    public int findCenterEdgeNum(){
        int result = -1;
        for(int i = 1; i < edgeArr.length; i++){
            if(edgeArr[i] == null) continue;
            Edge edge = edgeArr[i];
            if(edge.fromCount == 0 && edge.toCount > 1){
                result = i;
                break;
            }
        } 
        return result;
    }
    
    public Edge getEdge(int num){
        if(edgeArr[num] == null){
            edgeArr[num] = new Edge(num);
        }
        return edgeArr[num];
    }
    
    private class Edge{
        
        int num;
        int fromCount;
        int toCount;
        List<Edge> graph = new ArrayList<>();
        
        Edge(int num){
            this.num = num;
            this.fromCount = 0;
            this.toCount = 0;
        }
    }
    
}