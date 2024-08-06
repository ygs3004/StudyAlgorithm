import java.util.stream.*;

class Solution {
    public String solution(String myString) {
        return myString
            .chars()
            .mapToObj(c -> c - 'l' < 0 ? "l" : Character.toString(c)).collect(Collectors.joining());
    }
}