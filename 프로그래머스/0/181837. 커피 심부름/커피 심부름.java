import java.util.*;

class Solution {
    
    public int solution(String[] order) {
        
        final String AMERICANO = "americano";
        final String CAFFELATTE = "cafelatte";
        
        Map<String, Integer> price = new HashMap<>();
        price.put(AMERICANO, 4500);
        price.put(CAFFELATTE, 5000);
        int answer = 0;
        
        for(String menu : order){
            answer += menu.indexOf(CAFFELATTE) >= 0 ? price.get(CAFFELATTE) : price.get(AMERICANO);
        }

        return answer;
    }
    
}