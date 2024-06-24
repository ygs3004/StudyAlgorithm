import java.util.*;

class Solution {
    public double[] solution(int k, int[][] ranges) {
        double[] answer = new double[ranges.length];
        Queue<Integer> nums = new LinkedList<>();
        
        int n = k;
        while(n != 1){
            n = collartz(n);
            nums.add(n);
        }
        
        int trials = nums.size();
        
        double[] areas = new double[trials];
        int before = k;
        for(int i = 0; i < trials; i++){
            int now = nums.poll();
            int small = Math.min(now, before);
            int big = Math.max(now, before);
            
            int square = small;
            double triangle = (big - small) / (double)2;
            areas[i] = square + triangle;
            before = now;
        }
        
        for(int i = 0; i < answer.length; i++){
            int[] range = ranges[i];
            int from = range[0];
            int to = trials + range[1];
            if(from > to){
                answer[i] = -1;
            }else{
                double sum = 0;
                for(int p = from; p < to; p++){
                    sum += areas[p];
                }
                answer[i] = sum;
            }
        }
               
        return answer;
    }
    
    private int collartz(int n){
        return n % 2 == 0 ? (n / 2) : (n * 3) + 1;
    }
}