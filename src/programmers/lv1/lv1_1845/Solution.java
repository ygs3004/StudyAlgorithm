package programmers.lv1.lv1_1845;

import java.util.*;

class Solution {
    
    public int solution(int[] nums) {
        
        int[] distinctArr = Arrays.stream(nums).distinct().toArray();
        int a = distinctArr.length;
        int answer = 1;
        
        if(nums.length/2 >= a){
            answer = a;
        }else{
            answer = nums.length/2;
        }
       
        return answer;
    }
    
}