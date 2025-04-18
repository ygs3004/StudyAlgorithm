import java.util.*;

class Solution {

    public int[] solution(int n, int s) {
        if (s < n) {
            return new int[]{-1};
        }

        int[] result = new int[n];
        int baseValue = s / n;
        int remainder = s % n;
        Arrays.fill(result, baseValue);
        for (int i = n - remainder; i < n; i++) {
            result[i]++;
        }

        return result;
    }

}