import java.util.*;

class Solution {
    public int solution(int[][] routes) {

        boolean[] cleared = new boolean[routes.length];
        Arrays.sort(routes, (route1, route2) -> route1[1] - route2[1]);

        int answer = 0;
        int idx = 0;
        
        while(idx < routes.length){
            int[] route = routes[idx];
            answer++;
            
            int s = route[0];
            int e = route[1];
            while(routes[idx][0] <= e){
              idx++;
              if(idx >= routes.length) break;
            }

        }
    
        return answer;
    }
}