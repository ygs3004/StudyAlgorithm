package programmers.lv1.lv1_17682;

import java.util.*;

class Solution {
    
    public int solution(String dartResult) {
        
        String[] arr = dartResult.split("");
        int answer = 0;
        int nowNum = 1;
        int nowNumIdx = 1;
        int beforeNum = 0;
        List<String> numbers = Arrays.asList("0", "1", "2", "3", "4", "5", "6", "7", "8", "9");
        
        for(int i=0; i<arr.length; i++){
            
            if(arr[i].equals("1")){
                i++;
                if(arr[i].equals("0")) nowNum *= 10;
                else i--;
            }else if(numbers.contains(arr[i])){
                nowNum = Integer.parseInt(arr[i])*nowNum;
            }else if(arr[i].equals("D")){
                nowNum = (int)Math.pow(nowNum, 2);
            }else if(arr[i].equals("T")){
                nowNum = (int)Math.pow(nowNum, 3);
            }else if(arr[i].equals("#")){
                nowNum = -nowNum;
            }else if(arr[i].equals("*")){
                nowNum *= 2;
                beforeNum *= 2;
            }

            if(i != arr.length-1){
                if(numbers.contains(arr[i+1])){
                    answer += beforeNum;
                    beforeNum = nowNum;
                    nowNum = 1;
                    nowNumIdx++;
                }
            }
        }
        answer += nowNum + beforeNum;
        
        return answer;
    }
    
}