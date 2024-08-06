import java.util.*;

class Solution {
    public int[] solution(int n) {
        List<Integer> result = new ArrayList<>();
        while(n != 1){
            result.add(n);
            n = n % 2 == 0 ? n / 2 : 3 * n + 1;
        }
        result.add(1);
        
        return result.stream().mapToInt(Integer::intValue).toArray();
    }
}