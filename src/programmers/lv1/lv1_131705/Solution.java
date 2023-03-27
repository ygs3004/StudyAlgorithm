package programmers.lv1.lv1_131705;

import java.util.*;

class Solution {
    
    public int solution(int[] number) {
        
        Arrays.sort(number);
                
        int answer = 0;
        
        for(int i=0; i<number.length-2; i++){
            if(number[i]+number[i+1]+number[i+2]>0) break;
            for(int j=i+1; j<number.length-1; j++){
                for(int k=j+1; k<number.length; k++){
                    if(number[i]+number[j]+number[k] == 0) answer++;
                }
            }
        }

        return answer;
    }
    
}