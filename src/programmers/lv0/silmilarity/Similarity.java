package programmers.lv0.silmilarity;

import programmers.lv0.excute.ProgrammersInt;

import java.util.Arrays;

public class Similarity {

    public static void main(String[] args) {
        String[] s1 = {"a", "b", "c"};
        String[] s2 = {"com", "b", "d", "p", "c"};
        String[] s3 = {"n", "omg"};
        String[] s4 = {"m", "dot"};
        new Solution().result(s1, s2);
        new Solution().result(s3, s4);
    }
}

class Solution extends ProgrammersInt {
    public int solution(String[] s1, String[] s2) {
        return (int)Arrays.stream(s1).filter( v ->
                Arrays.stream(s2).filter( v2 -> v.equals(v2)).count() == 1
        ).count();
    }
}
