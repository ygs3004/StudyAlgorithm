import java.util.stream.*;
import java.util.*;

class Solution {
    public int[] solution(int[] num_list, int n) {
        return IntStream.concat(Arrays.stream(num_list).skip(n), Arrays.stream(num_list).limit(n)).toArray();
    }
}