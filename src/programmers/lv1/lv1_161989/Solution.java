package programmers.lv1.lv1_161989;

import java.util.*;
class Solution {
    
    public int solution(int n, int m, int[] section) {
        
        boolean[] wall = new boolean[section[section.length-1]+1];
        
        for(int block : section){
            wall[block] = true;
        }
        int start = section[0];
        int answer = 0;
        
        while(wall[wall.length-1]){
            for(int i = start; i<start+m; i++){
                wall[i] = false;
                if(i == wall.length-1) break;
            }
            answer++;
            if(start < wall.length-1){
                while(!wall[start]){
                    start++;    
                    if(start == wall.length-1) break;
                }                
            }
        }
        return answer;
    }
    
}
