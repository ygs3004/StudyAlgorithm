import java.util.*;
import java.util.stream.*;

class Solution {
    public int solution(int[] rank, boolean[] attendance) {
        int[] sorted = IntStream.range(0, rank.length)
            .filter(i -> attendance[i])
            .boxed()
            .sorted((idx1, idx2) -> rank[idx1] - rank[idx2])
            .mapToInt(Integer::intValue)
            .toArray();
       
        int a = sorted[0];
        int b = sorted[1];
        int c = sorted[2];
        
        return 10000 * a + 100 * b + c;
            
    }
}