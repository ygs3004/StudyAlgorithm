package programmers.lv1.lv1_12915;

import java.util.*;

class Solution {
    
    public String[] solution(String[] strings, int n) {

        Arrays.sort(strings, new Comparator<String>(){
           
            @Override
            public int compare(String a, String b){
                if(a.charAt(n) != b.charAt(n)){
                    return a.charAt(n) - b.charAt(n);
                }else{
                  for(int i=0; i<a.length(); i++){
                      if(i==n) continue;
                      if(a.charAt(i) != b.charAt(i)){
                          return a.charAt(i) - b.charAt(i);
                      }
                  }
                  
                  return 0;
                }
                
            }
            
        });
        
        return strings;
    }
    
}