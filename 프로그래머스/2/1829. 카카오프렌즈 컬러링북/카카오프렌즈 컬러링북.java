import java.util.*;

class Solution {
    
    final int EMPTY = 0;
    final int VISITED = -1;
    final int[] dr = {-1, 0, 1, 0};
    final int[] dc = {0, -1, 0, 1};
    
    public int[] solution(int m, int n, int[][] picture) {
        int numberOfArea = 0;
        int maxSizeOfOneArea = 0;
        
        for(int i = 0; i < m; i++){
            for(int j = 0; j < n; j++){
                int pixel = picture[i][j];
                if(pixel != EMPTY && pixel != VISITED){
                    picture[i][j] = VISITED;    
                    int picSize = checkColorBfs(picture, i, j, pixel);
                    numberOfArea++;
                    maxSizeOfOneArea = Math.max(picSize, maxSizeOfOneArea);
                }
                
            }
        }
        
        int[] answer = new int[2];
        answer[0] = numberOfArea;
        answer[1] = maxSizeOfOneArea;
        return answer;
    }
    
    private int checkColorBfs(int[][] picture, int r, int c, int color){
        
        Queue<int[]> que = new ArrayDeque<>();
        que.add(new int[]{r, c});
        int picSize = 0;
        
        while(!que.isEmpty()){
            picSize++;
            int[] next = que.poll();
            int curRow = next[0];
            int curCol = next[1];
            
            for(int i = 0; i < 4; i++){
                int nextRow = curRow + dr[i];
                int nextCol = curCol + dc[i];
                if(nextRow >= 0 && nextCol >= 0
                  && nextRow < picture.length && nextCol < picture[r].length
                  && picture[nextRow][nextCol] == color){
                    picture[nextRow][nextCol] = VISITED;
                    que.add(new int[]{nextRow, nextCol});
                }
            }            
        }

        return picSize;
    }
    
}