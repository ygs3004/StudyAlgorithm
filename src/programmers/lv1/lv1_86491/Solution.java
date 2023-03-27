package programmers.lv1.lv1_86491;

import java.util.*;

class Solution {
    
    public int solution(int[][] sizes) {
        
        int xMax = 0;
        int yMax = 0;
        
        for(int i=0; i<sizes.length; i++){
            Arrays.sort(sizes[i]);
            xMax = Math.max(sizes[i][0], xMax);
            yMax = Math.max(sizes[i][1], yMax);
        }
        
        return xMax * yMax;
    }
    
}