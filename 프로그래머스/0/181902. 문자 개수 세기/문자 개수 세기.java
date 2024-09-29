class Solution {
    public int[] solution(String my_string) {
        int[] answer = new int[52];
        
        for(int i = 0; i < my_string.length(); i++){
            char cur = my_string.charAt(i);
            if(cur - 'a' >= 0){
                answer[cur - 'a' + 26]++;
            }else{
                answer[cur - 'A']++;
            }
        }
            
        return answer;
    }
}