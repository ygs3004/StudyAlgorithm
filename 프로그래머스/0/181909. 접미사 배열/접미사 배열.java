import java.util.stream.*;

class Solution {
    public String[] solution(String my_string) {
        return IntStream.range(0, my_string.length())
            .mapToObj(i -> my_string.substring(my_string.length() - i - 1))
            .sorted()
            .toArray(String[]::new);
    }
}