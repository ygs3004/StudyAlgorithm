import java.util.*;

class Solution {
    public int solution(int[] stones, int k) {
        
        int left = 1;
        int right = 200_000_000;
        int result = Integer.MAX_VALUE;
        
        while(right >= left){
            int mid = (left + right) / 2;
            int count = 0;
            boolean done = true;
            for(int i = 0; i < stones.length; i++){
                if(stones[i] - mid <= 0){
                    count++;
                    if(count >= k){
                        done = false;
                      break;   
                    }
                }else{
                    count = 0;
                }
            }
            
            if(done){
                left = mid + 1;
            }else{
                result = Math.min(mid, result);
                right = mid -1;
            }
        }


        return result;
    }
}