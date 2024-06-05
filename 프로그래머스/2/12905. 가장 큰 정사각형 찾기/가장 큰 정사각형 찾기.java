class Solution{
    
    public int solution(int[][] board){
        
        int answer = 0;
        
        for(int i = 0; i < board.length; i++){
            for(int j = 0; j < board[0].length; j++){
                int value = board[i][j];
                board[i][j] = value == 0 ? 0
                    : (i - 1 < 0 || j - 1 < 0) ? 1
                        : Math.min(board[i-1][j], Math.min(board[i][j-1], board[i-1][j-1])) + 1;

                answer = Math.max(answer, (int)Math.pow(board[i][j], 2));
            }
        }
        return answer;
    }

}