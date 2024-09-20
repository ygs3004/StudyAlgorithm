import java.util.*;

class Solution {
    public int[] solution(int[] arr) {
        
        ArrayDeque<Integer> stack = new ArrayDeque<>();
        int i = 0;
        
        while(i < arr.length){
            if(stack.isEmpty()){
                stack.addLast(arr[i++]);
            }else{
                if(stack.peekLast() == arr[i]){
                    stack.pollLast();
                    i++;
                }else{
                    stack.addLast(arr[i++]);
                }
            }
        }
        
        int[] result = stack.isEmpty()
            ? new int[]{-1}
            : stack.stream().mapToInt(Integer::intValue).toArray();
        
        return result;
    }
    
}