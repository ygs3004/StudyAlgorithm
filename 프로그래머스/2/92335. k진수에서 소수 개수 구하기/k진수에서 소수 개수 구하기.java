import java.util.*;
class Solution {
    
    public int solution(int n, int k) {
        int a = 15;
        String convert = Integer.toString(a, 16);
        String convertNumber = Integer.toString(n, k);
        String[] numberArray = convertNumber.split("0");
        
        int answer = 0;
        for(String numberStr : numberArray){
            if(numberStr.equals("") || numberStr.equals("1")) continue;
            answer += isPrimeResult(numberStr);    
        }
        return answer;
    }
    
    private int isPrimeResult(String numberStr){
        long number = Long.parseLong(numberStr);
        long range = (long)Math.sqrt(number);
        
        for(long i = 2L; i <= range; i++){
            if(number % i == 0){
                return 0;
            } 
        }
        
        return 1;
    }   
}