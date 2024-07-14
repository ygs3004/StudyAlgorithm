import java.util.*;
import java.util.stream.*;

class Solution {
    public String solution(String my_string, int k) {
        StringBuilder sb = new StringBuilder();
        IntStream.range(0, k).forEach((n) -> {sb.append(my_string);});
        return sb.toString();
    }
}