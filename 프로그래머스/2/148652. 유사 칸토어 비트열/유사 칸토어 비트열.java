import java.util.*;

class Solution {
    public int solution(int n, long l, long r) {
        return (int)(calc(r, n) - calc(l - 1, n));
    }
    
    public long calc(long r, long n){
        long seg = (long) Math.pow(5, n - 1);
        long mod = r % seg;
        long div = r / seg;

        if(mod == 0){
            if(div <= 2){
                return div * (long)Math.pow(4, n - 1);
            }else{
                return (div - 1) * (long)Math.pow(4, n - 1);
            }
        }else{
            if(div <= 1){
                return div * (long)Math.pow(4, n - 1) + calc(mod, n - 1);
            }else if(div == 2){
                return div * (long)Math.pow(4, n - 1);
            }else{
                return (div - 1) * (long)Math.pow(4, n - 1) + calc(mod, n - 1);
            }
        }
    }
}