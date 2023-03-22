package programmers.lv0.lv0_120913;

class Solution {
    public String[] solution(String my_str, int n) {
        
        int strMaxIdx = my_str.length()-1;
        String[] answer = new String[(int)Math.ceil(strMaxIdx/n)+1];
        int strIdx = 0;
        int ansIdx = 0;
        String subStr = "";
        
        while(strIdx <= strMaxIdx){
            subStr = strIdx + n > strMaxIdx?my_str.substring(strIdx):my_str.substring(strIdx, strIdx+n);
            answer[ansIdx++] = subStr;
            strIdx += n;
        }
        
        return answer;
    }
}