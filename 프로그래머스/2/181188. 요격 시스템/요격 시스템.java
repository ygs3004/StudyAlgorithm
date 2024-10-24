import java.util.*;

class Solution {
    
    public int solution(int[][] targets) {

        boolean[] cleared = new boolean[targets.length];
        Arrays.sort(targets, (target1, target2) -> target1[1] - target2[1]);
        // for(int[] target: targets){
        //     System.out.println(Arrays.toString(target));
        // }

        int answer = 0;
        int idx = 0;
        
        while(idx < targets.length){
            int[] target = targets[idx];
            answer++;
            
            int s = target[0];
            int e = target[1];
            while(targets[idx][0] < e){
              idx++;
              if(idx >= targets.length) break;
            }

        }
    
        return answer;
    }
    
}