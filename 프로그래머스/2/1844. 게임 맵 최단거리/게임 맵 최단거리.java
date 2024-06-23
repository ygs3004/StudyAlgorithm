import java.util.*;

class Solution {
    
    int answer = Integer.MAX_VALUE;
    
    public int solution(int[][] maps) {
        
        Queue<int[]> queue = new LinkedList<>();
        Queue<Integer> stepQueue = new LinkedList<>();
        queue.add(new int[]{0, 0});
        maps[0][0] = 0;
        stepQueue.add(1);
        int xMax = maps.length - 1;
        int yMax = maps[0].length - 1;
        int count = 1;
        
        while(!queue.isEmpty()){
            
            int[] now = queue.poll();
            int nowStep = stepQueue.poll();
            int nextStep = nowStep + 1;
            int nowX = now[0];
            int nowY = now[1];
            
            if(nowX == xMax && nowY == yMax){
                answer = nowStep;
                break;
            }
            
            if(nowX-1 >= 0 && maps[nowX-1][nowY] == 1){
                maps[nowX-1][nowY] = 0;
                queue.add(new int[]{nowX-1,nowY});
                stepQueue.add(nextStep);
            }
            if(nowX+1 <= xMax && maps[nowX+1][nowY] == 1){
                maps[nowX+1][nowY] = 0;
                queue.add(new int[]{nowX+1,nowY});
                stepQueue.add(nextStep);
            }
            if(nowY-1 >= 0 && maps[nowX][nowY-1] == 1){
                maps[nowX][nowY-1] = 0;
                queue.add(new int[]{nowX,nowY-1});
                stepQueue.add(nextStep);
            }
            if(nowY+1 <= yMax && maps[nowX][nowY+1] == 1){
                maps[nowX][nowY+1] = 0;
                queue.add(new int[]{nowX,nowY+1});
                stepQueue.add(nextStep);
            }
             
        }
                
        return answer == Integer.MAX_VALUE ? -1 : answer;
    }
    
}