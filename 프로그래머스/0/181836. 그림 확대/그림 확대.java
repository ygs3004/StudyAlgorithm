import java.util.*;
import java.util.stream.*;

class Solution {
    public String[] solution(String[] picture, int k) {
        
        String[] result = new String[picture.length * k];
        
        for(int i = 0; i < picture.length; i++){
            String changed = picture[i].chars().mapToObj(c -> {
                StringBuilder sb = new StringBuilder();
                for(int j = 0; j < k; j++){
                    sb.append(Character.toString(c));
                }
                return sb.toString();
            }).collect(Collectors.joining());
            
            int copyIdx = i * k;
            for(int j = 0; j < k; j++){
                result[copyIdx + j] = changed;
            }
        }
        
        return result;
    }
}