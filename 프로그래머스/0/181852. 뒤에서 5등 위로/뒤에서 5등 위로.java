import java.util.*;

class Solution {
    public int[] solution(int[] num_list) {
        return Arrays.copyOfRange(Arrays.stream(num_list).sorted().toArray(), 5, num_list.length);
    }
}