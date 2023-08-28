package programmers.lv2.lv2_42578;

import java.util.*;
class Solution {
    public int solution(String[][] clothes) {
        Map<String, Integer> items = new HashMap<>();
        
        for(int i=0; i<clothes.length; i++){
            items.put(clothes[i][1], items.getOrDefault(clothes[i][1], 1)+1);
        }
        
        int answer = 1;
        for(Integer kindOfItem : items.values()){
            answer *= kindOfItem;
        }
        
        return answer == 1 ? 1 : answer - 1 ;
    }
}