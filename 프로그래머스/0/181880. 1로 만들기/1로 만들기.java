import java.util.*;

class Solution {
    public int solution(int[] num_list) {
        return Arrays.stream(num_list).map(num -> {
            int i = 0;
            while(num != 1){
                num /= 2;
                i++;
            }
            return i;
        }).sum();
    }
}