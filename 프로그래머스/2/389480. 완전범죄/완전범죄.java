import java.util.*;

class Solution {

    int nlimit;
    int mlimit;
    List<Evidence> infos;
    int[][] visitedMin;
    final int INF = 121;
    int answer;
    
    public int solution(int[][] info, int n, int m) {
        this.nlimit = n;
        this.mlimit = m;
        this.visitedMin = new int[info.length][121];   
        this.answer = INF;

        int mMax = 0;
        infos = new ArrayList<>();
        for(int[] eviInfo : info){
            infos.add(new Evidence(eviInfo[0], eviInfo[1]));
            mMax += eviInfo[1];
        }

        dfs(0, 0, 0, 0);
        dfs(1, 0, 0, 0);
        
        return answer == INF ? -1 : answer;
    }
    
    private void dfs(int select, int nsum, int msum, int depth){
        if(depth == infos.size()){
            answer = Math.min(nsum, answer);
            return;
        }
        
        Evidence evidence = infos.get(depth);
        if(select == 0) {
            nsum += evidence.n;
        }else{
            msum += evidence.m;  
        } 
        
        if(nsum >= nlimit || msum >= mlimit) return;
        
        int memory = visitedMin[depth][msum];
        if(memory == 0 || nsum < memory){
            visitedMin[depth][msum] = nsum;
            dfs(0, nsum, msum, depth + 1);
            dfs(1, nsum, msum, depth + 1);            
        }
    }
    
    private class Evidence{
        
        int n;
        int m;
        
        Evidence(int n, int m){
            this.n = n;
            this.m = m;
        }
    }
    
}