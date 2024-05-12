import java.util.*;

class Solution {
    
    public String solution(int n) {
        StringBuilder answer = new StringBuilder();
        while(n > 0){
            if(n % 3 == 0){
                answer.insert(0, "4");
                n = (n - 1)/3;
            }else{
                answer.insert(0, Integer.toString((n % 3)));
                n /= 3;
            }
        }
        return answer.toString();
    }
}
