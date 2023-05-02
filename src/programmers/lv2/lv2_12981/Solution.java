package programmers.lv2.lv2_12981;

import java.util.*;
class Solution {
    public int[] solution(int n, String[] words) {
        int answerIdx = Integer.MAX_VALUE;
        int searchIdx = 0;     
        int endIdx = words.length;
        
        for(int i=0; i<endIdx; i++){
            if(i != endIdx-1){
                if(words[i].charAt(words[i].length()-1) != words[i+1].charAt(0)){
                    if(i+1<= answerIdx){
                        return getAnswer(i+1, n);    
                    }
                }    
            }
            searchIdx = search(words, i+1, endIdx, words[i]);
            if(searchIdx > 0){
                answerIdx = Math.min(searchIdx, answerIdx);
            }
        }
        if(answerIdx<=endIdx){
            return getAnswer(answerIdx, n);
        }
        
        return new int[]{0, 0};
    }
    
    public int[] getAnswer(int index, int n){
        return new int[]{index%n+1, index/n+1};
    }
    
    public int search(String[] arr, int start, int end, String word){
        for(int i=start; i<end; i++){
            if(arr[i].equals(word)) return i;
        }
        return -1;
    }
}