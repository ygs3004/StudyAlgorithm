package programmers.lv2.lv2_12951;

class Solution {
    public String solution(String s) {
        StringBuilder answer = new StringBuilder();
        char a = 'a';
        String arr[] = s.split("");
        answer.append(arr[0].toUpperCase());
        
        for(int i=0; i<arr.length-1; i++){
            if(arr[i].equals(" ") && i != arr.length-1){
                arr[i+1] = arr[i+1].toUpperCase();
            }else if (i != arr.length-1){
                arr[i+1] = arr[i+1].toLowerCase();
            }                
            answer.append(arr[i+1]);
        }

        return answer.toString();
    }
}