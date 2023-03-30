package programmers.lv1.lv1_12977;

import java.util.*;

class Solution {
    
    public int solution(int[] nums) {
        
        Arrays.sort(nums);
        int max = nums[nums.length-1]+nums[nums.length-2]+nums[nums.length-3];
        boolean[] decimal = new boolean[max+1];
        
        for(int i= 2; i<=Math.sqrt(max+1); i++){
            if(decimal[i]) continue;
            for(int j=i*2; j<max+1; j+=i){
                decimal[j] = true;
            }
        }
        
        int count = 0;
        
        List<Integer> list = new ArrayList<>();
        
        for(int i=0; i<nums.length-2; i++){
            for(int j=i+1; j<nums.length-1; j++){
                for(int k=j+1; k<nums.length; k++){
                    list.add(nums[i]+nums[j]+nums[k]);
                }
            }
        }
        
        for(int a : list){
            if(!decimal[a]) count ++;
        }

        return count;
    }
    
}