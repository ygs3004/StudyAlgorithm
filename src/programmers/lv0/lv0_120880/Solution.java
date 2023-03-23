package programmers.lv0.lv0_120880;

import java.util.*;



class Solution {
    public Integer[] solution(int[] numlist, int n) {

        Integer[] answer = new Integer[numlist.length];

        for(int i=0; i<numlist.length; i++){
            answer[i] = numlist[i];
        }

        Arrays.sort(answer, new Comparator<Integer>(){
            public int compare(Integer a, Integer b) {
                
                if(Math.abs(n-(int)a) == Math.abs(n-(int)b)){
                  return b-a;
                }

                return Math.abs(n-(int)a) - Math.abs(n-(int)b);
            }
        });

        return answer;
    }
}