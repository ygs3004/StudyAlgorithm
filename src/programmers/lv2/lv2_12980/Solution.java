package programmers.lv2.lv2_12980;

import java.util.*;

public class Solution {
    public int solution(int n) {
        int ans = 1;
        while(n>1){
          if(n%2 != 0) ans++;
          n = n%2 == 0 ? n/2 : n-1;   
        }   
        return ans;
    }
}