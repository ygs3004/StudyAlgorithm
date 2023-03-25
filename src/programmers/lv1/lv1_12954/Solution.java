package programmers.lv1.lv1_12954;

import java.util.stream.LongStream;
class Solution {
    public long[] solution(int x, int n) {
        return LongStream.range(1, n+1).map(v -> x*v).toArray();
    }
}