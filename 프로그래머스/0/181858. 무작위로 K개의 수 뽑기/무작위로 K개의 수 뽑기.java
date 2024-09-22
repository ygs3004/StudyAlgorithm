import java.util.*;

class Solution {
    public int[] solution(int[] arr, int k) {
        int[] answer = new int[k];
        Arrays.fill(answer, -1);
        
        Set<Integer> set = new HashSet<>();
        int idx = 0;
        int compareSetSize = set.size();
        for(int num : arr){
            set.add(num);
            if(set.size() != compareSetSize){
                compareSetSize = set.size();
                answer[idx++] = num;
                if(idx >= k) break;
            }
        }

        return answer;
    }
}