package programmers.lv0.lv0_120868;

import java.util.*;

class Solution {
    
    public int solution(int[] paramSide) {
        
        int minimumSide = Math.abs(paramSide[1] - paramSide[0])+1;
        int maximumSide = paramSide[0] + paramSide[1]-1;
        int[] sides = new int[3];
        sides[0] = paramSide[0];
        sides[1] = paramSide[1];

        System.out.println(minimumSide);
        System.out.println(maximumSide);
        
        // int count = 0;
        // for(int i=minimumSide; i<=maximumSide; i++){
        //     sides[2] = i;
        //     if(checkTriangle(sides)) count++;
        // }
        
        
        return maximumSide-minimumSide+1;
        
    }
    
    static boolean checkTriangle(int[] sides){
        System.out.println(sides[2]);
        Arrays.sort(sides);
        if(sides[0]+sides[1] >= sides[2]) return true;
        else return false;
        
    }
    
}