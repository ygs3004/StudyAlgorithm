import java.util.*; 

class Solution {
    public int solution(int[] num_list) {
        return num_list.length > 10
            ? Arrays.stream(num_list).sum()
            : Arrays.stream(num_list).reduce(1, (acc, cur) -> acc * cur);
    }
}