import java.util.*;

class Solution {
    
    public int[] solution(String[] gems) {
        
        int left = 0;
        Map<String, Integer> map = new HashMap<>();
        
        int maxGemCnt = 0;
        int minLength = Integer.MAX_VALUE;
        
        int[] answer = new int[2];
        
        for(int right = 0; right < gems.length; right++){
            String gem = gems[right];
            
            map.compute(gem, (key, value) -> value == null ? 1 : value + 1);

            while(left < right){
                String gemLeft = gems[left];
                int leftGemCnt = map.getOrDefault(gemLeft, 0);
                if(leftGemCnt > 1){
                    map.compute(gemLeft, (key, value) -> value - 1);
                    left++;
                }else{
                    break;
                }
            }

            if(map.get(gem) > 1) continue;
                        
            int mapSize = map.size();
            if(mapSize >= maxGemCnt){
                if(mapSize > maxGemCnt || minLength > right - left){
                    answer[0] = left + 1;
                    answer[1] = right + 1;
                    maxGemCnt = mapSize;
                    minLength = right - left;    
                }
            }

        }   

        return answer;
    }
    
}