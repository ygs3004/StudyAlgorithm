import java.util.stream.*;

class Solution {
    public int[] solution(int n, int k) {
        return IntStream.iterate(k, num -> num <= n, num -> num + k).toArray();
    }
}