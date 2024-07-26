import java.util.*;
import java.util.stream.*;

class Solution {
    public String solution(String[] arr) {
        return Arrays.stream(arr).collect(Collectors.joining());
    }
}