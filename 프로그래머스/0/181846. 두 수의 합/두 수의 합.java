import java.math.*;

class Solution {
    public String solution(String a, String b) {
        return String.valueOf(new BigDecimal(a).add(new BigDecimal(b)));
    }
}