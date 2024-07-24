import java.util.*;

class Solution {
    public int[] solution(int[] arr) {
        return Arrays.stream(arr)
            .map(num -> num % 2 == 0 && num >= 50 ? num / 2
                    : num % 2 != 0 && num < 50 ? num * 2
                    : num)
            .toArray();
    }
}