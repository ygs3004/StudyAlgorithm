package programmers.lv1.lv1_12910;

import java.util.Arrays;

class Solution {
    public int[] solution(int[] arr, int divisor) {
        arr = Arrays.stream(arr).filter(v -> v%divisor == 0).toArray();
        Arrays.sort(arr);
        
        return arr.length == 0 ? new int[]{-1} : arr;
    }
}