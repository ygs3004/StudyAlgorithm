import java.util.*;

class Solution {
    public int[] solution(int[] arr) {
        Stack<Integer> stack = new Stack<>();
        
        for(int i = 0; i < arr.length; i++){
            if(arr[i] == 2) {
                if(stack.size() == 2) stack.pop();
                stack.push(i);
            }
        }
        
        if(stack.size() == 0) return new int[]{-1};
        if(stack.size() == 1) return new int[]{arr[stack.pop()]};

        int idxLast = stack.pop();
        int idxFirst = stack.pop();
        int[] answer = new int[idxLast - idxFirst + 1];
        int ansIdx = 0;
        for(int i = idxFirst; i <= idxLast; i++){
            answer[ansIdx++] = arr[i];
        }
        
        return answer;
    }
}