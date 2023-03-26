package programmers.lv1.lv1_12940;

class Solution {
    
    public int[] solution(int n, int m) {
        int[] answer = {gcd(n,m), n*m/gcd(n,m)};
        return answer;
    }
    
    static int gcd(int a, int b){
        
        if(b>a){
            int c = a;
            a = b;
            b = c;
        }
        
        if(a%b == 0) return b;
        
        return gcd(b, a%b);
        
    }
        
}