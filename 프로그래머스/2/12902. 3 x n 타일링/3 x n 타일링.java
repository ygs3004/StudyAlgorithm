class Solution {
    public int solution(int n) {
        
        long mod = 1_000_000_007;
        
        long[] dp = new long[5001];
        dp[2] = 3;
        
        for(int i = 4; i < dp.length; i++){
            if(i % 2 != 0){
                dp[i] = 0;
            }else{
                dp[i] = ((dp[i - 2] * 3) + 2) % mod;
                for(int j = i - 4; j > 0; j = j - 2){
                   dp[i] = (dp[i] + (dp[j] * 2) % mod) % mod;
                }
            }
        }

        return (int)dp[n];
    }
}