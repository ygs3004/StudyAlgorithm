package programmers.lv0.lv0_120905;

import java.util.Arrays;
    
class Solution {
    public int[] solution(int n, int[] numlist) {
        return Arrays.stream(numlist).filter ( v -> v%n == 0).toArray();
    }
}