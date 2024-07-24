import java.util.stream.*;

class Solution {
    public int solution(int[] num_list) {
        return IntStream.range(0, num_list.length)
            .filter(i -> num_list[i] < 0)
            .findFirst()
            .orElse(-1);
    }
}