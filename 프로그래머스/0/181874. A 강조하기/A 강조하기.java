import java.util.*;
import java.util.stream.*;

class Solution {
    public String solution(String myString) {
        return Arrays.stream(myString.split(""))
            .map(s -> s.equals("a") || s.equals("A") ? s.toUpperCase() : s.toLowerCase())
            .collect(Collectors.joining());
    }
}