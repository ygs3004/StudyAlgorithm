import java.util.*;

class Solution {
    
    static int[] dirRow = {0, 1, 0, -1};
    static int[] dirCol = {1, 0, -1, 0};
    static int size;
    static int[][] board;
    static boolean[][][] visited;
    
    final static int ROAD = 0;
    final static int WALL = 1;
    
    final static int BASE_COST = 100;
    final static int ADDED_COST = 500;
    
    static int answer;
    
    public int solution(int[][] board) {
        this.size = board.length;
        this.board = board;
        this.visited = new boolean[size][size][2];
        this.answer = Integer.MAX_VALUE;
        
        visited[0][0][0] = true;
        visited[0][0][1] = true;
        bfs();
        
        return answer;
    }
    
    private void bfs(){
        
        PriorityQueue<Point> que = new PriorityQueue<>();
        que.add(new Point(0, 0, -1, 0));
        
        while(!que.isEmpty()){
            Point now = que.poll();
            int row = now.row;
            int col = now.col;
            int dir = now.dir;
            int cost = now.cost;
            
            if(row == size - 1 && col == size - 1){
                this.answer = Math.min(this.answer, cost);
                continue;
            }
            
            // 시작 지점일 경우 미체크
            if(dir > -1){
                if(visited[row][col][dir % 2]){
                    continue;
                }

                visited[row][col][dir % 2] = true;
            }

            
            for(int i = 0; i < 4; i++){
                int nextRow = row + dirRow[i];
                int nextCol = col + dirCol[i];
                int nextCost = cost + this.BASE_COST;

                if(dir > -1 && dir % 2 != i % 2){
                    nextCost += this.ADDED_COST;
                }

                if(isMovable(nextRow, nextCol, i)){
                    que.add(new Point(nextRow, nextCol, i, nextCost));
                }
            }
            
        }
        
                
    }
    
    private static boolean isMovable(int row, int col, int dir){

        if(row >= 0 && col >= 0
          && row < size && col < size
          && !visited[row][col][dir % 2]
          && board[row][col] == ROAD){
            return true;
        }
        
        return false;
    }
    
    private static class Point implements Comparable<Point>{
        int row;
        int col;
        int dir;
        int cost;
        
        public Point(int row, int col, int dir, int cost){
            this.row = row;
            this.col = col;
            this.dir = dir;
            this.cost = cost;
        }
        
        @Override
        public int compareTo(Point o){
            return this.cost - o.cost;
        }
    }
}