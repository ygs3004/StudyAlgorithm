import java.util.*;

class Solution {
    public int[] solution(int[] numbers) {

        int[] answer = new int[numbers.length];
        Stack<Integer> bigNumbers = new Stack<>();
        
        for(int i=numbers.length-1; i>=0; i--){
            int baseNumber = numbers[i];
            answer[i] = -1;
            while(!bigNumbers.isEmpty()){
                if(bigNumbers.peek() > baseNumber){
                    answer[i] = bigNumbers.peek();
                    break;
                }else{
                    bigNumbers.pop();
                }
            }
            
            if(bigNumbers.isEmpty() || baseNumber < bigNumbers.peek()){
                bigNumbers.add(baseNumber);
            }
        }
        
        return answer;
    }
    
}