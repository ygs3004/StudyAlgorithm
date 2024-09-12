import java.util.*;

class Solution {
    public int[] solution(String[] intStrs, int k, int s, int l) {
        return Arrays.stream(intStrs)
            .mapToInt(str -> Integer.parseInt(str.substring(s, s + l)))
            .filter(num -> num > k)
            .toArray();
    }
}