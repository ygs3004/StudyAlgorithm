import java.util.stream.*;

class Solution {
    public int solution(int n) {
        return IntStream.rangeClosed(1, n)
            .filter( i -> i % 2 == n % 2 )
            .reduce( 0, (acc, cur) -> n % 2 == 0 ? acc + cur * cur : acc + cur);
    }
}