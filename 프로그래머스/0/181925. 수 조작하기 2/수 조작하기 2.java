import java.util.stream.*;
class Solution {
    public String solution(int[] numLog) {
        return IntStream.rangeClosed(0 + 1, numLog.length - 1).mapToObj(i -> {
            int changed = numLog[i] - numLog[i-1];
            return switch(changed){
                case 1 -> "w";
                case -1 -> "s";
                case 10 -> "d";
                case -10 -> "a";
                default -> "";
            };
        }).collect(Collectors.joining());
    }
}