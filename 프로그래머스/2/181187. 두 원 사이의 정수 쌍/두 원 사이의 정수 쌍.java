class Solution {
    public long solution(int r1, int r2) {
        long answer = 0;
        double r1Pow = Math.pow((long)r1, 2);
        double r2Pow = Math.pow((long)r2, 2);
        for(long x = 1; x <= r2; x++){
            double xPow = Math.pow(x, 2);
            long r1Y = (long)Math.ceil(Math.sqrt(r1Pow - xPow));
            long r2Y = (long)Math.floor(Math.sqrt(r2Pow - xPow));
            long count = r2Y - r1Y + 1;
            answer += count;
        }
            
        return answer * 4;
    }
    
}