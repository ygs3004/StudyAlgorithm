import java.util.stream.*;

class Solution {
    public int[] solution(int[] arr, int[][] queries) {
        IntStream.range(0, queries.length)
            .forEach(i -> IntStream
                     .rangeClosed(queries[i][0], queries[i][1])
                     .forEach(j -> arr[j]++));
        return arr;
    }
}