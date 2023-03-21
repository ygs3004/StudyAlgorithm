package programmers.lv0.lv0_120843;

class Solution {
    public int solution(int[] numbers, int k) {
 
        int arrLength = numbers.length;
        int answerIndex = -2;
        
        while(k-- >= 1){            
            answerIndex += 2;
            if(answerIndex >= arrLength) answerIndex-=arrLength;
        }
       
        return numbers[answerIndex];
        
    }
}