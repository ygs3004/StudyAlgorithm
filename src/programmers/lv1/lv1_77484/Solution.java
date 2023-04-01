package programmers.lv1.lv1_77484;

import java.util.*;
import java.util.stream.*;

class Solution {
    
    public int[] solution(int[] lottos, int[] win_nums) {
        
        int[] rank = {6, 6, 5, 4, 3, 2, 1};
        int zeroCount = 0;
        int correctCount = 0;
        
        List<Integer> list = Arrays.stream(win_nums).boxed().collect(Collectors.toList()); 
        for(int i=0; i<lottos.length; i++){
            if(lottos[i] == 0) zeroCount ++;
            else if(list.contains(lottos[i])) correctCount ++;
        }
        
        return new int[]{rank[correctCount + zeroCount], rank[correctCount]};
    }
    
}