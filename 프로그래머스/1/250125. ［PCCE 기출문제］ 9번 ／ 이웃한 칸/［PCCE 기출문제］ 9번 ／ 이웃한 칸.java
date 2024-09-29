class Solution {
    public int solution(String[][] board, int h, int w) {
        
        int[] dh = {0, 1, -1, 0};
        int[] dw = {1, 0, 0, -1};
        int boardSize = board.length;
        int answer = 0;
        String targetColor = board[h][w];
        System.out.println(targetColor);
        
        for(int i = 0; i < 4; i++){
            int checkH = h + dh[i];
            int checkW = w + dw[i];
            
            if(checkH >= 0
               && checkW >= 0
               && checkH < boardSize
               && checkW < boardSize
               && board[checkH][checkW].equals(targetColor)) answer++;
        }
        
        return answer;
    }
    
}