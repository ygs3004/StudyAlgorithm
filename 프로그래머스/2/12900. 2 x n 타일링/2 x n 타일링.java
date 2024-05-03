class Solution {
    public int solution(int n) {
        int[] dp = new int[60001];
        dp[0] = 0;
        dp[1] = 1;
        dp[2] = 2;
        for(int i=3; i<=n; i++){
            dp[i] = ((dp[i-2])%1000000007 + (dp[i-1])%1000000007)%1000000007;
        }
        return dp[n];
    }
}