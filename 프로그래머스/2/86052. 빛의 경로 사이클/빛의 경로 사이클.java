import java.util.*;

class Solution {
    
    int[] dr = {-1, 0, 1, 0};
    int[] dc = {0, 1, 0, -1};
    boolean[][][] visited;
    int entranceSize = 4;  
    int rowLength;
    int colLength;
    
    public int[] solution(String[] grid) {

        List<Integer> resultList = new ArrayList<>();
  
        rowLength = grid.length;
        colLength = grid[0].length();
        visited = new boolean[rowLength][colLength][entranceSize];
        
        for(int i = 0; i < rowLength; i++){
            for(int j = 0; j < colLength; j++){
                for(int k = 0; k < entranceSize; k++){
                    int cycleLength = dfs(i, j, k, grid);
                    if(cycleLength > 0){
                        resultList.add(cycleLength);
                    }
                }
            }
        }
        
        Collections.sort(resultList);
            
        int[] answer = resultList.stream().mapToInt(Integer::intValue).toArray();
        return answer;
        
    }
    
    public int dfs(int row, int col, int entrance, String[] grid){

        int cycleLength = 0;
        Queue<Node> que = new ArrayDeque<>();
        que.add(new Node(row, col, entrance));
        
        while(!que.isEmpty()){
            Node node = que.poll();
            int curRow = node.row;
            int curCol = node.col;
            int curEntrance = node.entrance;
            if(visited[curRow][curCol][curEntrance]) break;
            
            visited[curRow][curCol][curEntrance] = true;
            cycleLength++;
            char moveFlag = grid[curRow].charAt(curCol);
            int nextDirection = 0;  
            int nextEntrance = 0;
            
            switch(moveFlag){
                case 'S':
                    nextDirection = curEntrance + 2;
                    nextEntrance = curEntrance;
                    break;
                case 'R':
                    nextDirection = curEntrance - 1;
                    nextEntrance = curEntrance + 1;
                    break;
                case 'L':
                    nextDirection = curEntrance + 1;
                    nextEntrance = curEntrance - 1;
                    break;
            }

            nextDirection = (nextDirection + 4) % 4;
            nextEntrance = (nextEntrance + 4) % 4;
            int nextRow = ((curRow + dr[nextDirection]) + rowLength) % rowLength;
            int nextCol = ((curCol + dc[nextDirection]) + colLength) % colLength;
            
            que.add(new Node(nextRow, nextCol, nextEntrance));
        }

        return cycleLength;
    }
    
    private static class Node{
        int row;
        int col;
        int entrance;
        
        Node(int row, int col, int entrance){
            this.row = row;
            this.col = col;
            this.entrance = entrance;
        }
    }
    
}