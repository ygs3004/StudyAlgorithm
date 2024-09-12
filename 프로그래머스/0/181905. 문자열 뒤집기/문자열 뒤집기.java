import java.util.*;

class Solution {
    public String solution(String my_string, int s, int e) {
        List<String> reverseString = Arrays.asList(my_string.substring(s, e + 1).split(""));
        Collections.reverse(reverseString);
        return my_string.substring(0, s) + String.join("", reverseString) + my_string.substring(e + 1);
    }
}