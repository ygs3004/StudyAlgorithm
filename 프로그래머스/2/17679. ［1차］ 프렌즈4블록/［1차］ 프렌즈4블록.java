import java.util.*;

class Solution {
    
    public int solution(int y, int x, String[] board) {

        int result = 0;
        boolean isDone = false;
        
        while(!isDone){
            
            int[][] checkBoard = new int[y][x];
            boolean isMatch = false;
            for(int i=0; i<y-1; i++){
                for(int j=0; j<x-1; j++){
                    isMatch = check(i, j, board, checkBoard) || isMatch;
                }
            }
            
            if(isMatch){
                for(int j=0; j<x; j++){
                    for(int i=0; i<y; i++){
                        result += checkBoard[i][j];
                    }
                }
                changeBoard(board, checkBoard);
            }else{
                isDone = true;   
            }  
        }
        
        return result;
    }
    
    private boolean check(int posY, int posX, String[] board, int[][] checkBoard){
        char main = board[posY].charAt(posX);
        char r = board[posY].charAt(posX+1);
        char d = board[posY+1].charAt(posX);
        char rd = board[posY+1].charAt(posX+1);
        boolean isMatch =
            main != '0'
            && main == r 
            && main == d
            && main == rd;
        
        if(isMatch){
            checkBoard[posY][posX] = 1;
            checkBoard[posY][posX+1] = 1;
            checkBoard[posY+1][posX] = 1;
            checkBoard[posY+1][posX+1] = 1;
        }
        
        return isMatch;
    }
    
    private void changeBoard(String[] board, int[][] checkBoard){
        String[][] copyBoard = new String[board.length][board[0].length()];
        for(int i=0; i<checkBoard[0].length; i++){
            StringBuilder col = new StringBuilder();
            for(int j=0; j<checkBoard.length; j++){
                if(checkBoard[j][i] != 1){
                    col.append(Character.toString(board[j].charAt(i)));
                }
            }
            
            String colString = col.toString(); 
            int colIdx = colString.length()-1;
            for(int j=checkBoard.length-1; j>=0; j--){
                if(colIdx >= 0){
                    copyBoard[j][i] = Character.toString(colString.charAt(colIdx--));
                }else{
                    copyBoard[j][i] = "0";
                }
            }
        }
                    
        for(int j=0; j<board.length; j++){
            StringBuilder line = new StringBuilder();
            for(int i=0; i<board[0].length(); i++){
                line.append(copyBoard[j][i]);
            }
            board[j] = line.toString();
        }
    }
    
}