class Solution {
    
    public int solution(int[][] board, int[][] skill) {
        
        int[][] boardSum = new int[board.length + 1][board[0].length + 1];
        
        for(int[] info : skill){
            int type = info[0];
            int fromRow = info[1];
            int fromCol = info[2];
            int toRow = info[3];
            int toCol = info[4];
            int degree = info[5];
            
            int typeConstant = type == 1 ? -1 : 1;
            int value = typeConstant * degree;
            boardSum[fromRow][fromCol] += value;
            boardSum[toRow + 1][fromCol] += -value;
            boardSum[fromRow][toCol + 1] += -value;
            boardSum[toRow + 1][toCol + 1] += value;
        }
        
        for(int row = 0; row < boardSum.length; row++){
            for(int col = 1; col < boardSum[0].length; col++){
                boardSum[row][col] += boardSum[row][col - 1];
            }
        }
        
        for(int row = 1; row < boardSum.length; row++){
            for(int col = 0; col < boardSum[0].length; col++){
                boardSum[row][col] += boardSum[row - 1][col];
            }
        }

        int answer = 0;
        
        for(int i = 0; i < board.length; i++){
            for(int j = 0; j < board[0].length; j++){
                if(board[i][j] + boardSum[i][j] >= 1) answer++;
            }
        }
        
        return answer;
    }
}