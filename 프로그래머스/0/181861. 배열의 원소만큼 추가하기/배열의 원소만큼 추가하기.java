import java.util.*;
import java.util.stream.*;

class Solution {
    public int[] solution(int[] arr) {
        List<Integer> list = new ArrayList<>();
        Arrays.stream(arr).forEach(num -> {
           IntStream.range(0, num).forEach( iter -> list.add(num));
        });
        
        return list.stream().mapToInt(Integer::intValue).toArray();
    }
}