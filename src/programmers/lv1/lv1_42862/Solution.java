package programmers.lv1.lv1_42862;

import java.util.*;
class Solution {
    public int solution(int n, int[] lost, int[] reserve) {
        
        int[] students = new int[n+1];
        //  0 : 체육복이 없음  1 : 체육복을 하나, 2: 체육복이 두개
        
        for(int i=0; i<students.length; i++){
            students[i] = 1;
        }
        
        for(int i : lost){
            students[i]--;
        }
        
        for(int i : reserve){
            students[i]++;
        }
        
        for(int i=1; i<students.length; i++){
            if(students[i] == 0){
                if(students[i-1] == 2){
                    students[i-1] = 1;
                    students[i] = 1;
                }else if(i+1<students.length && students[i+1]==2){
                    students[i+1] = 1;
                    students[i] = 1;
                }
            }
        }
        
        int answer = 0;
        for(int i=1; i<students.length; i++){
            if(students[i] >= 1) answer ++;
        }
        return answer;
    }
    
}



