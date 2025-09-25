import java.util.*;

class Solution{
    public int solution(String s){
        
        int strLength = s.length();
        
        boolean[][] dp = new boolean[strLength][strLength];
        
        int answer = 1;
        
        for(int part = 1; part <= strLength; part++){
            for(int from = 0; from < strLength - part + 1; from++){
                int to = from + part - 1;
                
                if(part == 1){
                    dp[from][to] = true;
                    continue;
                }else if(part == 2){
                    char c1 = s.charAt(from);
                    char c2 = s.charAt(to);
                    if(c1 == c2){
                        dp[from][to] = true;
                        answer = Math.max(to - from + 1, answer);
                    }
                }else{
                    char c1 = s.charAt(from);
                    char c2 = s.charAt(to);
                    if(dp[from + 1][to - 1] && c1 == c2){
                        dp[from][to] = true;
                        answer = Math.max(to - from + 1, answer);
                    } 
                }
            }
        }

        return answer;
    }
    
    private static boolean isPallindrome(String s){
        
        for(int i = 0; i < s.length() / 2; i++){
            char c1 = s.charAt(i);
            char c2 = s.charAt(s.length() - 1 - i);
            if(c1 != c2) return false;
        }
        
        return true;
    }
}