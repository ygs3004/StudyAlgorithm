import java.util.*;

class Solution {
    
    String[][] map;
    boolean[][] visited;
    int foodSum;
    
    public int[] solution(String[] maps) {
        
        map = new String[maps.length][maps[0].length()];
        visited = new boolean[maps.length][maps[0].length()];
        ArrayList<Integer> result = new ArrayList<>();
        
        for(int i = 0; i < map.length; i++){
            map[i] = maps[i].split("");
        }
        
        for(int i = 0; i < map.length; i++){
            for(int j = 0; j < map[0].length; j++){
                if(!map[i][j].equals("X") && !visited[i][j]){
                    foodSum = 0;
                    dfs(i, j);
                    result.add(foodSum);
                }
            }
        }
        
        int[] answer;
        if(result.isEmpty()){
             answer = new int[]{-1};
        }else{
            Collections.sort(result);
            answer = new int[result.size()];
            for(int i = 0; i < answer.length; i++){
                answer[i] = result.get(i);
            }
        }
        
        return answer;
    }
    
    private void dfs(int row, int col){
        
        String land = map[row][col];
        visited[row][col] = true;
        if(land.equals("X")){
          return;   
        }
        int food = Integer.parseInt(land);
        foodSum += food;
        
        int[] directionX = new int[]{-1, 0, 1, 0};
        int[] directionY = new int[]{0, -1, 0, 1};
        
        for(int i = 0; i < 4; i++){
            int nextRow = row + directionX[i];
            int nextCol = col + directionY[i];
            
            if(nextRow < map.length && nextRow >= 0
                && nextCol < map[0].length && nextCol >= 0
                && !visited[nextRow][nextCol]){
                dfs(nextRow, nextCol);
            }
        }
    }
    
}