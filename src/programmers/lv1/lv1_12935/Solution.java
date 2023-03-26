package programmers.lv1.lv1_12935;

import java.util.Arrays;

class Solution {
    
    public int[] solution(int[] arr) {

        if(arr.length == 1) return new int[]{-1};
        int[] newArr = arr.clone();
        
        Arrays.sort(arr);
        
        int[] answer = new int[arr.length-1];
        int idx=0;
        
        for(int i=0; i<arr.length; i++){
            if(newArr[i] != arr[0]) answer[idx++] = newArr[i];
        }
        
        return answer;
    }
    
}