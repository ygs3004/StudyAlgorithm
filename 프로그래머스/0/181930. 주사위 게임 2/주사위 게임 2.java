import java.util.*;

class Solution {
    public int solution(int a, int b, int c) {
        Set<Integer> check = new HashSet<>();
        check.add(a);
        check.add(b);
        check.add(c);
        return calc(a, b, c, 4 - check.size());
    }
    
    public int calc(int a, int b, int c, int n){
        int result = 1;
        
        for(int i = 1; i <= n; i ++){
            result *= Math.pow(a, i) + Math.pow(b, i) + Math.pow(c, i);
        }
        
        return result;
    }
    
}