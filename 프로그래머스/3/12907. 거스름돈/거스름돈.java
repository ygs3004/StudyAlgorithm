import java.util.*;

class Solution {
    
    final static int MOD = 1_000_000_007;
    
    public int solution(int n, int[] money) {
       
        int[] dp = new int[100_001];
        dp[0] = 1;
        
        for(int i = 0; i < money.length; i++){
            int coin = money[i];
            
            for(int j = coin; j < 100_001; j++){
                dp[j] = modSum(dp[j], dp[j - coin]);
            }
        }
        
        int answer = dp[n];
        return answer;
    }
    
    private static int modSum(int a, int b){
        return ((a % MOD) + (b % MOD)) % MOD;
    }
}