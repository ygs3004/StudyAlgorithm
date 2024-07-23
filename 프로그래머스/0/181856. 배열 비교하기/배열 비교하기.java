import java.util.*;

class Solution {
    public int solution(int[] arr1, int[] arr2) {
        int answer = 0;
        if(arr1.length == arr2.length){
            int sum1 = sum(arr1);
            int sum2 = sum(arr2);
            answer = sum1 == sum2
                ? 0
                : sum1 > sum2 ? 1 : -1;
        }else{
            answer = arr1.length > arr2.length ? 1 : -1;  
        }
        return answer;
    }
    
    public int sum(int[] arr){
        return Arrays.stream(arr).sum();
    }
    
}