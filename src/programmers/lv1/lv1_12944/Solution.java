package programmers.lv1.lv1_12944;

import java.util.*;
class Solution {
    public double solution(int[] arr) {
        return Arrays.stream(arr).reduce((a,c) -> a+c).getAsInt()/(double)arr.length;
    }
}