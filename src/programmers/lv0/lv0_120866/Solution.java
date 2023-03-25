package programmers.lv0.lv0_120866;

class Solution {
    public int solution(int[][] board) {
        
        boolean[][] isDangerous = new boolean[board.length][board.length];
        
        for(int i=0; i<board.length; i++){
            for(int j=0; j<board[i].length; j++){
                if(board[i][j] == 1){
                    if(i-1>=0 && j-1>=0) isDangerous[i-1][j-1] = true;
                    if(i-1>=0) isDangerous[i-1][j] = true;    
                    if(j-1>=0) isDangerous[i][j-1] = true;
                    if(i+1<board.length) isDangerous[i+1][j] = true;
                    if(j+1<board.length) isDangerous[i][j+1] = true;
                    if(i+1<board.length && j+1<board.length) isDangerous[i+1][j+1] = true;
                    if(i-1>=0 && j+1<board.length) isDangerous[i-1][j+1] = true;
                    if(i+1<board.length && j-1>=0) isDangerous[i+1][j-1] = true;
                    isDangerous[i][j] = true;                    
                }
            }
        }
        
        int answer = 0;
        
        for(int i=0; i<board.length; i++){
            for(int j=0; j<board[i].length; j++){
                if(!isDangerous[i][j]){
                    System.out.println("i :"+i +" j: "+j);
                    answer ++;
                } 
            }
        }

        return answer;
    }
}