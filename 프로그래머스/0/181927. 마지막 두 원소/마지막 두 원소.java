import java.util.stream.*;
class Solution {
    public int[] solution(int[] num_list) {
        return IntStream.rangeClosed(0, num_list.length)
            .map( i -> i != num_list.length
                 ? num_list[i]
                 : num_list[i - 1] > num_list[i - 2]
                 ? num_list[i - 1] - num_list[i - 2]
                 : num_list[i - 1] * 2 ).toArray();
    }
}