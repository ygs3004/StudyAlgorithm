import java.util.*;
import java.util.stream.*;

class Solution {
    
    public int solution(String s) {
        int answer = s.length();
        
        for(int i = 1; i <= s.length()/2; i ++ ){
            answer = Math.min(answer, compress(s, i).length());
        }
        
        return answer;
    }
    
    private String compress(String s, int size){
        Stack<Token> stack = new Stack<>();
        for(int i = 0; i < s.length(); i = i + size){
            String curValue = i + size > s.length()
                ? s.substring(i)
                : s.substring(i, i + size);
            
            if(stack.isEmpty() || !stack.peek().value.equals(curValue)){
                stack.push(new Token(curValue));
            }else{
                stack.peek().compress++;
            }      
        }
        
        String result = "";
        while(!stack.isEmpty()){
            Token token = stack.pop();
            result = token.compress > 1 ? token.compress + token.value + result : token.value + result;
        }
        return result;
    }
    
    private class Token {
        int compress = 1;
        String value;
        
        Token(String value){
            this.value = value;
        }
    }
}