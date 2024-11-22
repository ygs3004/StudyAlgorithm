import java.util.*;

class Solution {
    
    int parkWidth;
    int parkHeight;
    
    public int solution(int[] mats, String[][] park) {
        this.parkWidth = park.length;
        this.parkHeight = park[0].length;
        int maxSize = 0;
        for(int i = 0; i < park.length; i++){
            for(int j = 0; j < park[0].length; j++){
                boolean checkSize = true;
                while(checkSize){
                    checkSize = check(park, i, j, maxSize);
                    if(checkSize) maxSize++;
                }
            }
        }
        maxSize--;
        Arrays.sort(mats);
        
        int answer = -1;
        for(int mat : mats){
            System.out.println("mat:" + mat);
            if(mat <= maxSize) answer = mat;
        }

        return answer;
    }
    
    boolean check(String[][] park, int row, int col, int size){
        if(size == 0) return true;
        
        int rowFrom = row;
        int rowTo = row + size - 1;
        int colFrom = col;
        int colTo = col + size - 1;
        
        if(!isValidRow(rowTo) || !isValidCol(colTo)) return false;
        
        for(int i = row; i <= rowTo; i++){
            for(int j = col; j <= colTo; j++){
                if(!park[i][j].equals("-1")){
                    return false;   
                }
            }
        }
        
        return true;
    }
    
    boolean isValidRow(int row){
        return row >= 0 && row < parkWidth;
    }
    
    boolean isValidCol(int col){
        return col >= 0 && col < parkHeight;
    }
    
}