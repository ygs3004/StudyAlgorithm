package programmers.lv2.lv2_70129;

class Solution {
    public int[] solution(String s) {
        int beforeLength = 0;
        int afterLength = 0;
        int zeroCount = 0;
        int tryCount = 0;
        while(!s.equals("1")){
            beforeLength = s.length();
            afterLength = deleteZeroLength(s);
            s = Integer.toBinaryString(afterLength);
            zeroCount += beforeLength - afterLength;
            tryCount++;
        }
        
        int[] answer = {tryCount, zeroCount};
        return answer;
    }
    
    public static int deleteZeroLength(String s){
        return s.replace("0", "").length();
    }
}