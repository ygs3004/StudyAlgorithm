import java.util.*;
class Solution {
    
    public int solution(int n, int k, int[] enemy) {    
        
        PriorityQueue<Integer> que = new PriorityQueue<>();
        int answer = 0;
        
        int enemies = 0;
        for(int i = 0; i < enemy.length; i++){
            if(k > 0){
                k--;
                que.add(enemy[i]);
                answer++;
                continue;
            }
            
            int queMin = que.peek();
            if(enemy[i] > queMin){
                enemies += que.poll();
                que.add(enemy[i]);                
            }else{
                enemies += enemy[i];
            }
            
            if(enemies > n){
                break;
            }
            
            answer++;
        }
        
        return answer;
    }

}