import java.util.*;

class Solution {
    
    String[] maps;
    
    public int solution(String[] maps) {
        this.maps = maps;
        int[] start = new int[2];
        int[] end = new int[2];
        int[] button = new int[2];
        for(int i = 0; i < maps.length; i++){
            for(int j = 0; j < maps[i].length(); j++){
                char pos = maps[i].charAt(j);
                if(pos == 'S'){
                    start[0] = i;
                    start[1] = j;
                }else if(pos == 'L'){
                    button[0] = i;
                    button[1] = j;
                }else if(pos == 'E'){
                    end[0] = i;
                    end[1] = j;
                }
            }
        }
        
        int toButton = calcSec(start, button);
        int toEnd = calcSec(button, end);
        int answer = toButton + toEnd;
        
        return toButton == 0 || toEnd == 0 ? -1 : answer;
    }
    
    private int calcSec(int[] start, int[] end){
        
        Queue<Node> queue = new LinkedList<>();
        int startRow = start[0];
        int startCol = start[1];
        int endRow = end[0];
        int endCol = end[1];
        int result = 0;
        
        boolean[][] visited = new boolean[maps.length][maps[0].length()];
        queue.add(new Node(startRow, startCol, 0));
        visited[startRow][startCol] = true;
        
        int[] dirRow = new int[]{1, 0, -1, 0};
        int[] dirCol = new int[]{0, 1, 0, -1};
        
        while(!queue.isEmpty()){
            Node now = queue.poll();
            if(now.row == endRow && now.col == endCol){
                result = now.time;
                break;
            }
            
            int nextTime = now.time + 1;
            
            for(int i = 0; i < 4; i ++){
                int nextRow = now.row + dirRow[i];
                int nextCol = now.col + dirCol[i];
                
                if(nextRow >= 0 && nextRow < maps.length
                   && nextCol >= 0 && nextCol < maps[0].length()
                   && !visited[nextRow][nextCol]
                   && maps[nextRow].charAt(nextCol) != 'X'){
                    visited[nextRow][nextCol] = true;
                    queue.add(new Node(nextRow, nextCol, nextTime));        
                }
            }
            
        }
        
        return result;
        
    }
    
    private class Node{
        int row;
        int col;
        int time;
        
        Node(int row, int col, int time){
            this.row = row;
            this.col = col;
            this.time = time;
        }
    }
    
}