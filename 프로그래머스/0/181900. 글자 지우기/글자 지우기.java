import java.util.*;
import java.util.stream.*;

class Solution {
    public String solution(String my_string, int[] indices) {
        String[] str =  my_string.split("");
        String removeFlag = "X";
        for(int ind : indices){
            str[ind] = removeFlag;
        }
        return Arrays.stream(str).filter(s -> !s.equals(removeFlag)).collect(Collectors.joining());
    }
}