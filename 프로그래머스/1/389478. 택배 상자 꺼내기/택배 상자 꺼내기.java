import java.util.*;

class Solution {
    public int solution(int n, int w, int num) {
        Deque<Integer>[] stacks = new ArrayDeque[w];
        for(int i = 0; i < w; i++){
            stacks[i] = new ArrayDeque<>();
        }
        
        int idx = 0;
        int targetIdx = 0;
        for(int i = 0; i < n; i++){
            
            int now = i + 1;
            int div = i / w;
            
            Deque stack = stacks[idx];
            stack.push(now);
            if(now == num) targetIdx = idx;
            if(now % w != 0){
                if(div % 2 == 0){
                    idx++;
                }else if(div % 2 == 1){
                    idx--;
                }                
            }
        }
        
        int answer = 0;
        while(!stacks[targetIdx].isEmpty()){
            int now = stacks[targetIdx].pop();
            answer++;
            
            if(now == num) break;
        }
        
        return answer;
    }
}