import java.util.*;

class Solution {
    public int[] solution(int[] arr, int k) {
        return Arrays.stream(arr).map(num -> k % 2 == 0 ? num + k : num * k).toArray();
    }
}