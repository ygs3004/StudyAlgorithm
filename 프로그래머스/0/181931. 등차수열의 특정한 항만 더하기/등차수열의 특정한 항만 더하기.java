import java.util.stream.*;
class Solution {
    public int solution(int a, int d, boolean[] included) {
        return IntStream.range(0, included.length)
            .filter(i -> included[i])
            .map(i -> i * d + a)
            .sum();
    }
}