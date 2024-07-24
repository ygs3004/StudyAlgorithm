import java.util.stream.*;

class Solution {
    public int[] solution(int[] num_list, int n) {
        return IntStream
            .iterate(0, num -> num +n)
            .limit(num_list.length % n == 0 ? num_list.length / n : num_list.length / n + 1 )
            .map(i -> num_list[i])
            .toArray();
    }
}