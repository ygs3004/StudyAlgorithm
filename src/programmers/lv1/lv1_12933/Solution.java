package programmers.lv1.lv1_12933;

import java.util.*;
import java.util.stream.Collectors;
class Solution {
    public long solution(long n) {
        
        List<Integer> list = String.valueOf(n)
                .chars()
                .map(Character::getNumericValue)
                .boxed()
                .collect(Collectors.toList());

        Collections.sort(list, Collections.reverseOrder());

        Iterator irr = list.iterator();

        String result = "";
        while(irr.hasNext()){
            result += irr.next();
        }
        
        return Long.parseLong(result);
    }
}