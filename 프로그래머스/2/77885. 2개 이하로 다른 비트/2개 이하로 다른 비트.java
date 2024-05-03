class Solution {
    public long[] solution(long[] numbers) {
        long[] answer = new long[numbers.length];
        for(int i=0; i<numbers.length; i++){
            answer[i] = convert(numbers[i]);
        }
        return answer;
    }
    
    public long convert(long number){
        long result = 0;
        String numberStr = Long.toString(number, 2);
        
        if(number % 2 == 0){
            result = number + 1;
        }else if(numberStr.indexOf("0") < 0){
            result = Long.parseLong("10"+numberStr.substring(1), 2);
        }else {
            int idx = numberStr.length() - 3;
            while(idx >= 0){
                String prefix = numberStr.substring(0, idx);
                String compare = numberStr.substring(idx, idx+3);
                String suffix = numberStr.substring(idx+3);
                boolean isDone = false;
                switch(compare){
                    case "001": 
                        result = Long.parseLong(prefix +"010" + suffix, 2);
                        isDone = true;
                        break;
                    case "101":
                        result = Long.parseLong(prefix +"110" + suffix, 2);
                        isDone = true;
                        break;
                }
                if(isDone) break;
                idx--;
            }
        }
        return result;
    }
    
}