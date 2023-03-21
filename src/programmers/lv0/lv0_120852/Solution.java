package programmers.lv0.lv0_120852;

import java.util.*;
class Solution {
    public List<Integer> solution(int n) {
        
        boolean[] check = new boolean[n+1];
        List<Integer> list = new ArrayList<>();
        
        for(int i=2; i<=n; i++){
            
            if(check[i]) continue;
            
            for(int j=i; j<=n; j+=i){
                check[j] = true;  
            }
            
            if(n%i == 0) list.add(i);
            
        }
        
        if(!check[n]) list.add(n);
        
        return list;
    }
}