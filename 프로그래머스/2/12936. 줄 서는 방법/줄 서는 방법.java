import java.util.*;

class Solution {
    
    public int[] solution(int n, long k) {
    
        long size = factorial(n);
        int[] answer = new int[n];
        ArrayList<Integer> number = new ArrayList();
        
        for(int i = 1; i <= n; i++){
            number.add(i);
        }
        
        for(int i = 0; i < answer.length - 1; i++){
            int seq = (int)((k-1) /(size / n));
            answer[i] = number.remove(seq);
            size = size/n;
            k = (k-1) % size + 1;
            n--;
        }
        
        answer[answer.length - 1] = number.remove(0);
        
        return answer;
    }
    
    private long factorial(int n){
        long result = 1;
        for(int i = 1; i <= n; i++){
            result *= i;
        }
        
        return result;
    }

}