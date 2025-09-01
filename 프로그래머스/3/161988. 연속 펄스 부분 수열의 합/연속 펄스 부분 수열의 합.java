import java.util.*;

class Solution {
    
    public long solution(int[] sequence) {
        int length = sequence.length;
        long max1 = 0;
        long max2 = 0;
        long answer = 0;
        
        for(int i = 0; i < length; i++){
            long product = i % 2 == 0 ? 1 : - 1;
            long value = product * (long)sequence[i];
            
            max1 = Math.max(value, max1 + value);
            max2 = Math.max(-value, max2 - value);
            
            answer = Math.max(answer, Math.max(max1, max2));
        }

        
        return answer;
    }
    
}