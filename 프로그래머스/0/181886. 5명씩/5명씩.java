import java.util.stream.*;

class Solution {
    public String[] solution(String[] names) {
        return IntStream.range(0, names.length)
            .filter(i -> i % 5 == 0)
            .mapToObj(i -> names[i])
            .toArray(String[]::new);
    }
}