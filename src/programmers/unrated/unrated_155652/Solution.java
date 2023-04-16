package programmers.unrated.unrated_155652;

import java.util.*;
class Solution {
    public String solution(String s, String skip, int index) {
        
        String alphabet = "abcdefghijklmnopqrstuvwxyz";
        String[] skips = skip.split("");
        for(String skipChar : skips){
            alphabet = alphabet.replaceAll(skipChar, "");
        }
        String answer = "";
        List<String> alphabetParams = Arrays.asList(alphabet.split(""));
        String[] sChar = s.split("");
        
        for(int i=0; i<sChar.length; i++){
            int newIdx = alphabetParams.indexOf(sChar[i]) + index;
            while(newIdx>=alphabetParams.size()){
                newIdx %= alphabetParams.size();
            }
            answer += alphabetParams.get(newIdx);
        }
        return answer;
    }
}