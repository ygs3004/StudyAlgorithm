package programmers.lv2.lv2_76502;

import java.util.*;
class Solution {
    public int solution(String s) {
        int answer = 0;
        
        for(int i=0; i<s.length(); i++){
            answer = isCorrect(s) ? answer+1 : answer;
            s = sMoveLeft(s);    
        }
        
        return answer;
    }
    
    public boolean isCorrect(String s){
        
        Stack<Character> stack = new Stack<>();
        char[] sArr = s.toCharArray();
        for(char c : sArr){
            if(c=='[' || c=='(' || c=='{'){
                stack.add(c);
            }else if(stack.isEmpty()){
                return false;
            }else{
                char popC = stack.pop();
                if((c==']' && popC == '[') || (c==')' && popC =='(') || (c=='}' && popC =='{')) continue;
                return false;
            }
        }
        return stack.isEmpty();
    }
    
    public String sMoveLeft(String s){
        StringBuilder sb = new StringBuilder(s);
        sb.insert(0, sb.charAt(s.length()-1));
        sb.deleteCharAt(sb.length()-1);
        return sb.toString();
    }
    
}