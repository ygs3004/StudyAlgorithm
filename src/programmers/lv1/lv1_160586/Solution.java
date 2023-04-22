package programmers.lv1.lv1_160586;

import java.util.*;
class Solution {
    public int[] solution(String[] keymap, String[] targets) {
        int[] answer = new int[targets.length];
        
        for(int i=0; i<targets.length; i++){
            String target = targets[i];
            int pushForString = 0;
            int pushForChar = 0;
            for(int j=0; j<target.length(); j++){
                String targetChar = String.valueOf(target.charAt(j));
                pushForChar = Integer.MAX_VALUE;
                for(int k=0; k<keymap.length; k++){
                    if(keymap[k].indexOf(targetChar)!=-1){
                        pushForChar = Math.min(pushForChar, keymap[k].indexOf(targetChar)+1);    
                    }
                }
                if(pushForChar != Integer.MAX_VALUE) pushForString += pushForChar;
                else break;
            }

            if(pushForChar == Integer.MAX_VALUE){
                answer[i] = -1;
                continue;
            }
            answer[i] = pushForString == 0 ? -1 : pushForString;
        }
        return answer;
    }
}