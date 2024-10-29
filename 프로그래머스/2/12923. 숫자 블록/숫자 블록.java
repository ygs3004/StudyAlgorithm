import java.util.*;

class Solution {
    public int[] solution(long begin, long end) {
        long endMax = 1000000000;
        long blockMax = 10000000;
        endMax = Math.min(endMax, end);
        blockMax = Math.min(blockMax, end);
        
        int[] answer = new int[(int)(end - begin) + 1];
        for(int i = (int)begin; i <= end; i++){
            int idx = (int)(i - begin);

            if(i == 1){
                answer[idx] = 0;
            }else { 
                answer[idx] = 1;
                for(int j = 2; j <= Math.sqrt(i); j++){
                    if(i % j == 0 && i / j <= blockMax){
                        answer[idx] = i / j;
                        break;
                    }else if(i % j == 0 && j <= blockMax && j > answer[idx]){
                        answer[idx] = j;
                    }
                }
            }
        }
        
        return answer;
    }

}