import java.util.stream.*;
import java.util.*;

class Solution {
    public int solution(String myString, String pat) {
        return Arrays.stream(myString.split(""))
            .map(c -> c.equals("A") ? "B" : "A")
            .collect(Collectors.joining())
            .contains(pat) ? 1 : 0;
    }
}