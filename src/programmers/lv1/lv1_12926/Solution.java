package programmers.lv1.lv1_12926;

class Solution {
    public String solution(String s, int n) {

        String answer = "";
        
        char[] arr = s.toCharArray();
        for(int i=0; i<arr.length; i++){
            
            if(arr[i] == 32) {
                answer += " ";
                continue;
            }
            if(arr[i]>=97 && arr[i]<=122 & arr[i]+n>122){
                arr[i] = (char)((int)arr[i] + n - 26);
            }else if(arr[i] >= 65 && arr[i] <= 90 && arr[i]+n >90){
                arr[i] = (char)((int)arr[i] + n - 26);
            }else{
                arr[i] = (char)((int)arr[i] + n);    
            }
            answer += String.valueOf(arr[i]);
        }
        
        return answer;
    }
    
}