import java.util.*;

class Solution {
    public String[] solution(String myString) {
        return Arrays.stream(myString.split("x")).sorted().filter(s -> s.length() != 0).toArray(String[]::new);
    }
}