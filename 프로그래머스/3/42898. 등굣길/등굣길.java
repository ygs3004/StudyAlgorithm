import java.util.*;

class Solution {
    
    static final int PUDDLE_AREA = -1;
    static final int DIV = 1_000_000_007;
    static final int INF = DIV + 1;
    
    public int solution(int m, int n, int[][] puddles) {
        
        int[][] dp = new int[m][n];
        
        for(int[] puddle: puddles){
            int r = puddle[0] - 1;
            int c = puddle[1] - 1;
            dp[r][c] = PUDDLE_AREA;
        }
        dp[0][0] = 1;
        
        int[] dr = {0, 1};
        int[] dc = {1, 0};
        
        for(int r = 0; r < m; r++){
            for(int c = 0; c < n; c++){
                if(dp[r][c] == PUDDLE_AREA) continue;
                
                for(int d = 0; d < 2; d++){
                    int nextR = r + dr[d];
                    int nextC = c + dc[d];
                    
                    if(nextR < m && nextC < n && dp[nextR][nextC] != PUDDLE_AREA){
                        dp[nextR][nextC] = ((dp[r][c] % DIV) + (dp[nextR][nextC] % DIV)) % DIV;
                    }
                }
            }
        }
        
        // for(int[] r : dp){
        //     System.out.println(Arrays.toString(r));
        // }
        
        return dp[m - 1][n - 1];
    }
}