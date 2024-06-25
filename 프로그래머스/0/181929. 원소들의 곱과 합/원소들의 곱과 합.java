import java.util.*;

class Solution {
    public int solution(int[] num_list) {
        int multiply = Arrays.stream(num_list).reduce(1, (acc, cur) -> acc * cur);
        int sum = Arrays.stream(num_list).sum();
        return multiply < sum * sum ? 1 : 0;
    }
}