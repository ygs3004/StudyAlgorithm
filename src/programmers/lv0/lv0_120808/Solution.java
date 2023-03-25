package programmers.lv0.lv0_120808;

class Solution {
    public int[] solution(int numer1, int denom1, int numer2, int denom2) {
        
        int sumDenom = denom1 * denom2;
        int sumNumer = numer1*denom2 + numer2*denom1;
        
        int gcdNumber = gcd(sumDenom, sumNumer);
        
        int[] answer = {sumNumer/gcdNumber, sumDenom/gcdNumber};
        
        return answer;
    }
    
    // 최대공약수
    public static int gcd(int a, int b){
        // a가 b보다 큰 수로 설정
        if(a<b){
            int c = a;
            a = b;
            b = c;
        }
        
        if(a%b == 0) return b;
        
        return gcd(b, a%b);
            
    }
    
}