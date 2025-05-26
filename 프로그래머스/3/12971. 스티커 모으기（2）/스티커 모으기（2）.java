class Solution {
    public int solution(int sticker[]) {
        int stickerLength = sticker.length;
        
        int[][] dp = new int[4][stickerLength];
        dp[0][0] = 0;
        dp[1][0] = sticker[0];
        dp[2][0] = 0;
        dp[3][0] = 0;
        
        for(int i = 1; i < stickerLength; i++){
            int beforeNotUseWithFirst = dp[0][i-1];
            int beforeUseWithFirst = dp[1][i-1];
            int beforeNotUseWithoutFirst = dp[2][i-1];
            int beforeUseWithoutFirst = dp[3][i-1];
            
            if(i == stickerLength - 1){
                dp[0][i] = Math.max(beforeUseWithFirst, beforeNotUseWithFirst);
                dp[1][i] = Math.max(beforeUseWithFirst, beforeNotUseWithFirst);
                dp[2][i] = Math.max(beforeUseWithoutFirst, beforeNotUseWithoutFirst);
                dp[3][i] = beforeNotUseWithoutFirst + sticker[i];
            }else {
                dp[0][i] = Math.max(beforeUseWithFirst, beforeNotUseWithFirst);
                dp[1][i] = beforeNotUseWithFirst + sticker[i];
                dp[2][i] = Math.max(beforeUseWithoutFirst, beforeNotUseWithoutFirst);
                dp[3][i] = beforeNotUseWithoutFirst + sticker[i];
            }

        }
        
        
        int answer = 0;
        for(int i = 0; i < 4; i++){
            answer = Math.max(answer, dp[i][stickerLength - 1]);
        }
        return answer;
    }
}