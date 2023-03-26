package programmers.lv1.lv1_12918;

class Solution {
    
    public boolean solution(String s) {
        
        try{
            if(s.length() != 4 && s.length() != 6) return false;
            Integer.parseInt(s);
        }catch(Exception e){
            return false;
        }
        
        return true;
    }
    
}