package programmers.lv1.lv1_12916;

class Solution {
    
    boolean solution(String s) {
        
        boolean answer = true;
        int check = 0;
        
        char[] sArr = s.toLowerCase().toCharArray();
        
        for(char a : sArr){
            check = a == 'p' ? check+1 : a == 'y' ? check-1 : check;
        }
        
        return check == 0;
    }
    
}