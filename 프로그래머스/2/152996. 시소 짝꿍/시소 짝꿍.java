import java.util.*;

class Solution {
    public long solution(int[] weights) {
        
        Arrays.sort(weights);
        int[] count = new int[4001];
        int[] rates = new int[]{2,3,4};
        int[] weightHistory = new int[100001];
        long answer = 0;
        
        for(int weight: weights){
            int sameWeightCount = weightHistory[weight];
            answer += sameWeightCount;

            for(int rate : rates){
                int torque = weight*rate;
                answer += count[torque] - sameWeightCount;
                count[torque]++;
            }           
            weightHistory[weight]++;
        }
        
        return answer;
    }
    
}