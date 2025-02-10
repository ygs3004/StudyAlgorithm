import java.util.*;

class Solution {
    
    public int solution(int[] schedules, int[][] timelogs, int startday) {
        
        int answer = 0;
        
        for(int people = 0; people < schedules.length; people++){
            int target = schedules[people];
            int targetMin = target % 100 + 10;
            int targetHour = target / 100;   
            
            if(targetMin >= 60){
                targetMin = targetMin - 60;
                targetHour++;
            }
            
            int success = 0;
            for(int i = 0; i < 7; i++){
                int day = startday + i;
                if(day % 7 == 6 || day % 7 == 0) continue;
                
                int log = timelogs[people][i];
                int logMin = (log % 100);
                int logHour = log / 100;
                
                if(logHour < targetHour || (logHour == targetHour) && logMin <= targetMin){
                    success++;
                }
                
            }
            
            final int successTarget = 5;
            if(success == successTarget) answer++;
        }
        
        return answer;
    }
    
        
}