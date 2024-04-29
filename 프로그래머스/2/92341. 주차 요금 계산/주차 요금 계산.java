import java.util.*;

class Solution {
    
    int DEFAULT_PERIOD;
    int DEFAULT_FEE;
    int UNIT_PERIOD;
    int UNIT_FEE;
    
    public int[] solution(int[] fees, String[] records) {
        DEFAULT_PERIOD = fees[0];
        DEFAULT_FEE = fees[1];
        UNIT_PERIOD = fees[2];
        UNIT_FEE = fees[3];
        Map<String, Parking> car = new HashMap<>();
        
        for(String record : records){
            String[] recordInfo = record.split(" ");
            String timeStr = recordInfo[0];
            String carNum = recordInfo[1];
            String inOrOut = recordInfo[2];
            if(inOrOut.equals("IN")){
                if(car.containsKey(carNum)){
                    car.get(carNum).setIn(timeStr);
                }else{
                    car.put(carNum, new Parking(timeStr));                    
                }
            }else{
                car.get(carNum).setOut(timeStr);
            }
        }

        Object[] carNums = car.keySet().toArray();
        Arrays.sort(carNums);
        
        int[] answer = new int[carNums.length];
        for(int i=0; i<carNums.length; i++){
            answer[i] = car.get(carNums[i]).calculateFee();
        }
        
        return answer;
    }
    
    private class Parking{
        ArrayList<Integer> in = new ArrayList<>();
        ArrayList<Integer> out = new ArrayList<>();
        int lastIdx = -1;
        
        Parking(String inTimeString){
            setIn(inTimeString);
        }
        
        public void setIn(String inTimeString){
            in.add(timeStrToMin(inTimeString));
            out.add(23*60 + 59);
            lastIdx++;
        }
        
        public void setOut(String outTimeString){
            out.remove(lastIdx);
            out.add(timeStrToMin(outTimeString));
        }
        
        private int timeStrToMin(String timeStr){
            String[] time = timeStr.split(":");
            return Integer.parseInt(time[0]) * 60 + Integer.parseInt(time[1]);
        }
        
        public int calculateFee(){
            int result = 0;
            int chargeParkingTime = 0;
            while(lastIdx >= 0){
                int inTime = in.get(lastIdx);
                int outTime = out.get(lastIdx);
                lastIdx--;    
                chargeParkingTime += outTime - inTime;
            }
            
            return  result = chargeParkingTime > DEFAULT_PERIOD
                    ? DEFAULT_FEE + (int)Math.ceil((chargeParkingTime-DEFAULT_PERIOD)/(double)UNIT_PERIOD) * UNIT_FEE
                    : DEFAULT_FEE;
        }
    }
}