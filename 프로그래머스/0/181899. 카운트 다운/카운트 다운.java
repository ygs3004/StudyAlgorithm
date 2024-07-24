import java.util.stream.*;
import java.util.*;

class Solution {
    public int[] solution(int start_num, int end_num) {
        return IntStream
            .rangeClosed(end_num, start_num)
            .boxed()
            .sorted(Comparator.reverseOrder())
            .mapToInt(Integer::intValue)
            .toArray();
    }
}