class Solution {
    
    public long solution(int k, int d) {
        long cnt = 0;
       
        for(long a = 0; a <= d; a = a + k){
            long b = (long)Math.sqrt(Math.pow(d, 2) - Math.pow(a, 2));
            // long b = (long)Math.sqrt((d * d) - (a * a));
            cnt += (b / k) + 1;
        }
        
        return cnt;
    }
    
}