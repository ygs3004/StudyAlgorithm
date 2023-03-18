package programmers.lv0.lv0_120851;

class Solution {
    public int solution(String my_string) {
        int result = 0;
        for(int i=0; i<my_string.length(); i++){
            result += checkString(my_string.charAt(i));
        }
        return result;
    }
    
    public int checkString(char a){
        int ret = 0;
        try{
            ret = Integer.valueOf(String.valueOf(a));
        }catch(Exception e){
            
        }
        return ret;
    }
}