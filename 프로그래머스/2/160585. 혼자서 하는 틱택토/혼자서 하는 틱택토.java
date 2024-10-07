class Solution {
    
    static String MARK_O = "O";
    static String MARK_X = "X";
    
    public int solution(String[] board) {

        int countO = 0;
        int countX = 0;
        
        for(String row : board){
            String[] points = row.split("");
            for(String point : points){
                if(point.equals(MARK_O)) countO++;
                else if(point.equals(MARK_X)) countX++;
            }
        } 

        boolean isPossible = true;
        if(countX + 1 != countO && countX != countO){
            isPossible = false;
        }else{
            String lastMark = countX == countO ? MARK_X : MARK_O;
            String anotherMark = lastMark.equals(MARK_X) ? MARK_O : MARK_X;
            int lastComplete = checkComplete(board, lastMark);
            int anotherComplete = checkComplete(board, anotherMark);
            
            if(lastComplete > 2 || anotherComplete > 0) isPossible = false;
        }
        
        return isPossible ? 1 : 0;
    }
    
    public int checkComplete(String[] board, String mark){
        int rowComplete = checkRow(board, mark);
        int colComplete = checkCol(board, mark);
        int crossComplete = checkCross(board, mark);
        return rowComplete + colComplete + crossComplete;
    }
    
    public int checkRow(String[] board, String mark){
        int result = 0;
        for(int i = 0; i < board.length; i++){
            boolean isSuccess = true;
            for(int j = 0; j < board[0].length(); j++){
                if(!Character.toString(board[i].charAt(j)).equals(mark)){
                    isSuccess = false;
                }
            }
            if(isSuccess) result++;
        }
        return result;
    }
    
    public int checkCol(String[] board, String mark){
        int result = 0;
        for(int i = 0; i < board[0].length(); i++){
            boolean isSuccess = true;
            for(int j = 0; j < board.length; j++){
                if(!Character.toString(board[j].charAt(i)).equals(mark)){
                    isSuccess = false;
                }
            }
            if(isSuccess) result++;
        }
        return result;
    }
    
    public int checkCross(String[] board, String mark){
        int result = 0;
        
        boolean isSuccess = true;
        for(int i = 0; i < board.length; i++){
            if(!Character.toString(board[i].charAt(i)).equals(mark)){
                isSuccess = false;
            }
        }
        if(isSuccess) result++;
        
        isSuccess = true;
        for(int i = 0; i < board.length; i++){
            if(!Character.toString(board[i].charAt(board.length - 1 - i)).equals(mark)){
                isSuccess = false;
            }
        }
        if(isSuccess) result++;
        
        return result;
    }
}