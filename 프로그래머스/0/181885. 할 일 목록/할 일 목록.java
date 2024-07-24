import java.util.*;
import java.util.stream.*;

class Solution {
    public String[] solution(String[] todo_list, boolean[] finished) {
        return IntStream.range(0, todo_list.length)
            .filter(i -> !finished[i])
            .mapToObj(i -> todo_list[i])
            .toArray(String[]::new);
    }
}