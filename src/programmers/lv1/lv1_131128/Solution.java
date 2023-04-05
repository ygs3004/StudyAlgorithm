package programmers.lv1.lv1_131128;

import java.util.*;
class Solution {
    public String solution(String X, String Y) {
        String[] x = X.split("");
        String[] y = Y.split("");
        Arrays.sort(x);
        Arrays.sort(y);
        
        int xIdx = x.length-1;
        int yIdx = y.length-1;
        StringBuilder sb = new StringBuilder();
        boolean isZero = true;
        
        while(xIdx >= 0 && yIdx >= 0){
            if(Integer.parseInt(x[xIdx]) < Integer.parseInt(y[yIdx])){
                yIdx--;
            }else if(Integer.parseInt(y[yIdx]) < Integer.parseInt(x[xIdx])){
                xIdx--;
            }else{
                sb.append(x[xIdx]);
                if(!x[xIdx].equals("0")) isZero = false;
                xIdx--;
                yIdx--;
            }
        }
        
        if(sb.toString().length() == 0) return "-1";
        if(isZero) return "0";

        return sb.toString();
    }
    
}