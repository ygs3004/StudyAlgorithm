package programmers.lv1.lv1_160586;

import java.util.*;
class Solution {
    public int[] solution(String[] keymap, String[] targets) {
        int[] answer = new int[targets.length];
        
        for(int i=0; i<targets.length; i++){
            String target = targets[i];
            int pushForString = 0;
            int pushForChar = 0;
            int push = 0;
            for(int j=0; j<target.length(); j++){
                String targetChar = String.valueOf(target.charAt(j));
                push = Integer.MAX_VALUE;
                for(int k=0; k<keymap.length; k++){
                    if(keymap[k].indexOf(targetChar)!=-1){
                        push = Math.min(push, keymap[k].indexOf(targetChar)+1);    
                    }
                }
                if(push != Integer.MAX_VALUE) pushForChar += push;
                else break;
            }

            if(push == Integer.MAX_VALUE){
                answer[i] = -1;
                continue;
            } 
            pushForString += pushForChar;
            answer[i] = pushForString == 0 ? -1 : pushForString;
        }
        return answer;
    }
}