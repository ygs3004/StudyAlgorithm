package programmers.lv1.lv1_12930;

class Solution {
    public String solution(String s) {
        StringBuilder sb = new StringBuilder();
        String[] strArr = s.split("");
        int idx = 0;
        
        for(int i=0; i<strArr.length; i++){
            if(strArr[i].equals(" ")){
                idx=0;
                sb.append(" ");
                continue;
            }
            
            if(idx%2==0){
                sb.append(strArr[i].toUpperCase());
                idx++;
            }else{
                sb.append(strArr[i].toLowerCase());
                idx++;
            }
        }
        
        return sb.toString();
    }
}