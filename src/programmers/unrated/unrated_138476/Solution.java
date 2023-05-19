package programmers.unrated.unrated_138476;

import java.util.*;
import java.util.stream.*;
class Solution {
    public int solution(int k, int[] tangerine) {
        Map<Integer, Integer> quantityOfSizePerTangerine = new HashMap<>();
        
        for(int sizeOfTangerine : tangerine){
            quantityOfSizePerTangerine.put(
                sizeOfTangerine,
                quantityOfSizePerTangerine.getOrDefault(sizeOfTangerine, 0) + 1);
        }
        
        List<Integer> sameSizeValues = quantityOfSizePerTangerine.values()
            .stream()
            .sorted(Comparator.reverseOrder())
            .collect(Collectors.toList());
        
        int indexPerSize = 0;
        int total = 0;
            
        while(total<k){
            total += sameSizeValues.get(indexPerSize);
            indexPerSize++;
        }
        
        return indexPerSize;
    }
}