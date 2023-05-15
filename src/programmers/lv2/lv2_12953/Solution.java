package programmers.lv2.lv2_12953;

class Solution {
    public int solution(int[] arr) {
        int answer = 0;
        int acc = arr[1];
        
        for(int cur : arr){
            acc = lcm(acc, cur);
        }
        return acc;
    }
    
    public static int gcd(int a, int b){
        if(b>a){
            int temp = a;
            a = b;
            b = temp;
        }
        if(a%b == 0){
            return b;
        }else{
            return gcd(b, a%b);
        }
    }
    
    public static int lcm(int a, int b){
        int gcd = gcd(a,b);
        return a*b/gcd;
    }
}