package programmers.lv0.lv0_120902;

class Solution {
    public int solution(String my_string) {
        
        String[] str = my_string.split(" ");
        int answer = Integer.parseInt(str[0]);
        
        for(int i=1; i<str.length; i++){
            if(str[i].equals("+")){
                answer += Integer.parseInt(str[i+1]);
            }else if(str[i].equals("-")){
                answer -= Integer.parseInt(str[i+1]);
            }
        }

        return answer;
    }
}