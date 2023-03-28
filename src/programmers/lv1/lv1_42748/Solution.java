package programmers.lv1.lv1_42748;

import java.util.*;
class Solution {
    
    public int[] solution(int[] array, int[][] commands) {
        int[] answer = new int[commands.length];
        
        for(int l=0; l<commands.length; l++){
            int[] ijk = commands[l];
            int i = ijk[0]; int j = ijk[1]; int k =ijk[2];
            int[] newArr = Arrays.copyOfRange(array, i-1, j);
            Arrays.sort(newArr);
            answer[l] = newArr[k-1];
        }
        
        return answer;
    }
    
}