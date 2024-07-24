import java.util.*;
import java.util.stream.*;

class Solution {
    public String[] solution(String my_string) {
        return Arrays
            .stream(my_string.trim().split(" "))
            .filter(s -> !s.equals(""))
            .toArray(String[]::new);
    }
}