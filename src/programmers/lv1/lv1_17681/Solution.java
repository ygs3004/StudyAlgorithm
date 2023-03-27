package programmers.lv1.lv1_17681;

class Solution {
    public String[] solution(int n, int[] arr1, int[] arr2) {
        String[] answer = new String[n];
        
        for(int i=0; i<n; i++){

            String str1 = Integer.toBinaryString(arr1[i]);
            String str2 = Integer.toBinaryString(arr2[i]);
            
            String zero = "";
            
            if(str1.length()<n){
                for(int j=0; j<n-str1.length(); j++){
                    zero += "0";
                }
                str1 = zero + str1;
            }
            
            zero = "";
            if(str2.length()<n){
                for(int j=0; j<n-str2.length(); j++){
                    zero += "0";
                }
                str2 = zero + str2;
            }

            String line = "";
            for(int j=0; j<n; j++){
                if(str1.charAt(j) == '1' || str2.charAt(j) == '1') line += "#";
                else line += " ";
            }
            
            answer[i] = line;
            
        }
        return answer;
    }
}