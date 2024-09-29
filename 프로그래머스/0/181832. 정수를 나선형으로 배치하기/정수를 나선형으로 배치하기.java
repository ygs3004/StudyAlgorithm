class Solution {
    public int[][] solution(int n) {
        int[][] answer = new int[n][n];
        int[] dc = {1, 0, -1, 0};
        int[] dr = {0, 1, 0, -1};
        int direction = 0;
        int end = (int)Math.pow(n, 2);
        int cur = 1;
        int curRow = 0;
        int curCol = 0;
        answer[0][0] = cur;
        
        while(cur < end){
            int nextRow = curRow + dr[direction];
            int nextCol = curCol + dc[direction];
            while(!isNext(answer, nextRow, nextCol)){
                direction++;
                direction %= 4;
                nextRow = curRow + dr[direction];
                nextCol = curCol + dc[direction];
            }
                        
            cur++;
            answer[nextRow][nextCol] = cur;

            curRow = nextRow;
            curCol = nextCol;
        }
        
        return answer;
    }
    
    public boolean isNext(int[][] arr, int r, int c){
        return r >= 0 && c >=0 && r < arr.length && c < arr[0].length && arr[r][c] == 0;
    }
}
