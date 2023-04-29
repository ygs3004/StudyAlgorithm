package programmers.lv2.lv2_12941;

import java.util.*;

class Solution{
    public int solution(int [] a, int [] b){
        int answer = 0;
        Arrays.sort(a);
        Arrays.sort(b);
        for(int i=0; i<a.length; i++){
            answer += a[i]*b[b.length-i-1];
        }
        return answer;
    }
}