import java.util.*;

class Solution {
    
    final static int MIN_PER_HOUR = 60;
    final static int BUS_START_HOUR = 9;
    
    public String solution(int n, int t, int m, String[] timetable) {
        Arrays.sort(timetable);
        int busTimeMin = BUS_START_HOUR * MIN_PER_HOUR;
        int seq = 0;        
        busTimeMin = busTimeMin - t;
        String answer = "";
        
        for(int i = 0; i < n; i++){
            busTimeMin = busTimeMin + t;
            int remain = m;
            
            String lastTime = timetable[seq];
            int currentTimeMin = timeToMin(lastTime);
            while(currentTimeMin <= busTimeMin && remain > 0){
                seq++;
                remain--;
                
                if(seq > timetable.length - 1){
                    break;
                }
                lastTime = timetable[seq];
                currentTimeMin = timeToMin(lastTime);
            }
            
            if(i == n - 1 && remain <= 0){
                lastTime = timetable[seq - 1];
                currentTimeMin = timeToMin(lastTime);
                answer = minToTime(currentTimeMin - 1);
            }else if(i == n - 1){
                answer = minToTime(busTimeMin);
            }
            
            // System.out.println("seq: " + seq);
            // System.out.println("remain: " + remain);
        }
        
        // System.out.println(fullCount);
        // if(fullCount == n){
        //     answer = minToTime(timeToMin(timetable[0]) - 1);
        // }
        
        return answer;
    }
    
    private static int timeToMin(String time){
        String[] timeInfo = time.split(":");
        int hourPart = Integer.parseInt(timeInfo[0]) * MIN_PER_HOUR;
        int minPart = Integer.parseInt(timeInfo[1]);
        return hourPart + minPart;
    }
    
    private static String minToTime(int timeMin){
        int hourPart = timeMin / 60;
        int minPart = timeMin % 60;
        
        String hourPartStr = lpad(String.valueOf(hourPart));
        String minPartStr = lpad(String.valueOf(minPart));
        
        return hourPartStr + ":" + minPartStr;
    }
    
    private static String lpad(String s){
        while(s.length() < 2){
            s = "0" + s;
        }
        
        return s;
    }
}