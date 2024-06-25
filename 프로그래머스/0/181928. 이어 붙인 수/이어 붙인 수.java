import java.util.*;

class Solution {
    public int solution(int[] num_list) {
        StringBuilder odd = new StringBuilder();
        StringBuilder even = new StringBuilder();
        
        for(int num : num_list){
            if(num % 2 == 0){
                even.append(String.valueOf(num));
            }else{
                odd.append(String.valueOf(num));
            }
        }
        
        return Integer.parseInt(odd.toString()) + Integer.parseInt(even.toString());
    }
}