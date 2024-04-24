import java.util.*;

class Solution {
    public int solution(int[] topping) {
        
        int result = 0;
        Map<Integer, Integer> firstCutTopping = new HashMap<>();
        Map<Integer, Integer> compareTopping = new HashMap<>();
        for(int i=0; i<topping.length; i++){
            addKey(firstCutTopping, topping[i]);
        }
        
        for(int i=topping.length-1; i>=0; i--){
            subtractKey(firstCutTopping, topping[i]);
            addKey(compareTopping, topping[i]);
            if(compareTopping.size() == firstCutTopping.size()) {
                result++;
            }
        }
        
        return result;
    }
    
    private void addKey(Map<Integer, Integer> map, int key){
        map.put(key, map.getOrDefault(key, 0) + 1);
    }
    
    private void subtractKey(Map<Integer, Integer> map, int key){
        int value = map.get(key) - 1;
        if(value == 0){
            map.remove(key);
        }else{
            map.put(key, value);    
        }
    }
    
}