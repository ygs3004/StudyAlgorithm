import java.util.*;

class Solution {
    public String solution(String p) {
        return convert(p);
    }
    
    private String convert(String w){
        
        if(w.length() == 0) return w;
        int leftCase = 0;
        int rightCase = 0;
        if(w.charAt(0) == '('){
            leftCase++;
        }else{
            rightCase++;
        };        
        
        int index = w.length();
        for(int i = 1; i < w.length(); i++){
            if(w.charAt(i) == '('){
                leftCase++;
            }else{
                rightCase++;
            };     
            
            if(leftCase == rightCase) {
                index = i + 1;
                break;
            }
        }
        
        String u = w.substring(0, index);
        String v = w.substring(index);
        
        v = convert(v);
        
        String result = "";
        
        if(isCorrect(u)){
            result = u + v;
        }else{
            result = "(" + v + ")" + turnString(u);
        }
        
        return result;
    }

    
    private boolean isCorrect(String s){
        if(s.charAt(0) == ')') return false;
        
        Stack<Character> stack = new Stack<>();
        
        for(int i = 0; i < s.length(); i++){
            if(stack.isEmpty() || stack.peek() == s.charAt(i)){
                stack.push(s.charAt(i));
            }else{
                stack.pop();
            }
        }
        return stack.size() == 0;
    }
    
    private String turnString(String s){
        StringBuilder sb = new StringBuilder();
        for(int i = 1; i < s.length()-1; i++){
            sb.append(s.charAt(i) == ')' ? '(' : ')');
        }
        return sb.toString();
    }
}