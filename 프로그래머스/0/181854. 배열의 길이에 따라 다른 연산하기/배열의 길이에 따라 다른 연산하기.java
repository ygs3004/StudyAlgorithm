import java.util.stream.*;

class Solution {
    public int[] solution(int[] arr, int n) {
        return arr.length % 2 != 0
            ? IntStream.range(0, arr.length).map(i -> i % 2 == 0 ? arr[i] + n : arr[i]).toArray()
            : IntStream.range(0, arr.length).map(i -> i % 2 != 0 ? arr[i] + n : arr[i]).toArray();
    }
}