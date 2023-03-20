package programmers.lv0.lv0_120896;

import java.util.Arrays;

class Solution {
    public String solution(String s) {
        
        char[] arr = s.toCharArray();
        String answer = "";
        
        for(int i=0; i<arr.length; i++){
            char a = arr[i];
            if(s.indexOf(a) != s.lastIndexOf(a)){
                s.replaceAll(String.valueOf(a), "");
            }else{
                answer += a;
            }
        }
        
        System.out.println(answer);
        
        char[] charAnswer = answer.toCharArray();
        Arrays.sort(charAnswer);
        
        answer = "";
        for(int i=0; i<charAnswer.length; i++){
            answer += Character.toString(charAnswer[i]);
        }
        
        return answer;
    }
}