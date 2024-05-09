class Solution {
    int curIdx = 0;
    boolean[] visited;
    String[] direction = {"D", "R", "U"};
    int directionIdx = 0;
    
    int row = 1;
    int col = 1;
    int max = 0;
    int number;
    
    public int[] solution(int n) {
        number = n;
        
        for(int i = 0; i<=n; i++){
            max += i;
        }
        
        visited = new boolean[max];
        int[] answer = new int[max];
        
        for(int i=1; i<=max; i++){
            answer[curIdx] = i;
            visited[curIdx] = true;
            String curDirection = getDirection();
            if(!isMovable(curDirection)){
                directionIdx++;
                curDirection = getDirection();
            }
            moveIdx(curDirection);
        }
        
        return answer;
    }

    private String getDirection(){
        return this.direction[directionIdx%3];
    }
    
    private boolean isMovable(String curDirection){
        boolean isMovable = false;
        int nextIdx = 0;
        switch(curDirection) {
            case "D":
                nextIdx = curIdx + row;
                isMovable = nextIdx < max && row < number && !visited[nextIdx];
                break;
            case "R":
                nextIdx = curIdx + 1;
                isMovable = col < row && !visited[nextIdx];
                break;
            case "U":
                nextIdx = curIdx - row;
                isMovable = nextIdx > 0 && row > 0 && !visited[nextIdx];
                break;
        }
        return isMovable;
    }
    
    private void moveIdx(String curDirection){
        switch(curDirection) {
            case "D":
                curIdx = curIdx + row;
                row++;
                break;
            case "R":
                curIdx = curIdx + 1;
                col++;
                break;
            case "U":
                curIdx = curIdx - row;
                row--;
                col--;
            break;
        }
    }
        
}