import java.util.*;

class Solution {
    public int solution(String num_str) {
        return Arrays.stream(num_str.split(""))
            .map(num -> Integer.parseInt(num))
            .reduce(0, (acc, cur) -> acc + cur);
    }
}