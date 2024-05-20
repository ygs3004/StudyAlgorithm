import java.util.*;

class Solution {
    public int solution(int[] arrayA, int[] arrayB) {
        Arrays.sort(arrayA);
        Arrays.sort(arrayB);
        
        int gcdA = arrayGcd(arrayA);
        int gcdB = arrayGcd(arrayB);
        
        int answer1 = calculateFitNumber(arrayA, gcdB);
        int answer2 = calculateFitNumber(arrayB, gcdA);
        
        return Math.max(answer1, answer2);
    }
    
    private int calculateFitNumber(int[] arr, int num){
        for(int i = arr.length - 1; i >= 0; i--){
            if(arr[i] % num == 0){
                return 0;
            }
        }
        
        return num;
    }
    
    private int arrayGcd(int[] arr){
        int gcd = arr[0];
        for(int i = 1; i < arr.length; i++){
            gcd = gcd(arr[i], gcd);
        }
        return gcd;
    }
    
    private int gcd(int a, int b){
        if(b > a){
            int temp = b;
            b = a;
            a = temp;
        }
        
        return b == 0 ? a : gcd(b, a%b);
    }
}