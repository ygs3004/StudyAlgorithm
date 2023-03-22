package programmers.lv0.lv0_120913;

class Solution {
    public String[] solution(String my_str, int n) {
        
        int strMaxIndex = my_str.length()-1;
        String[] answer = new String[(int)Math.ceil(strMaxIndex/n)+1];
        int index = 0;
        int ansIndex = 0;
        String subStr = "";
        
        while(index <= strMaxIndex){
            if(index+n > strMaxIndex){
                subStr = my_str.substring(index);
            }else{
                subStr = my_str.substring(index, index+n);
            }
                answer[ansIndex++] = subStr;
                index += n;
        }
        
        return answer;
    }
}