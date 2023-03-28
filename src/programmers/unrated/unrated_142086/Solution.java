package programmers.unrated.unrated_142086;

class Solution {
    
    public int[] solution(String s) {
        
        int[] answer = new int[s.length()];
        answer[0] = -1;
        
        String[] str = s.split("");
        
        for(int i=1; i<str.length; i++){
            int count = 0;
            for(int j=i-1; j>=0; j--){
                count++;
                if(str[i].equals(str[j])){
                    answer[i] = count;
                    break;
                } 
            }
            if(answer[i] == 0) answer[i] = -1;
        }
        
        return answer;
    }
    
}