package programmers.lv1.lv1_12932;

import java.util.*;
import java.util.stream.Collectors;

class Solution {
    
    public List<Integer> solution(long n) {
        List<Integer> result = Arrays.stream(String.valueOf(n).split(""))
                .mapToInt(Integer::parseInt).boxed().collect(Collectors.toList());

        Collections.reverse(result);

        return result;
    }
    
}