package programmers.lv0.lv0_120840;

import java.math.*;
class Solution {
    
    public BigInteger solution(int balls, int share) {
        // n!/ (n-m)! x m!
        BigInteger numerator = new BigInteger("1");
        BigInteger denonimator = new BigInteger("1");
        BigInteger inumber = null;

        if(balls-share > share){
            for(int i=balls; i>balls-share; i--){
                inumber = new BigInteger(String.valueOf(i));
                numerator = numerator.multiply(inumber);
            }   
            for(int i=share; i>1; i--){
                inumber = new BigInteger(String.valueOf(i));
                denonimator = denonimator.multiply(inumber);
            }
            
        }else{
            for(int i=balls; i>share; i--){
                inumber = new BigInteger(String.valueOf(i));
                numerator = numerator.multiply(inumber);
            }
            for(int i=balls-share; i>1; i--){
                inumber = new BigInteger(String.valueOf(i));
                denonimator = denonimator.multiply(inumber);
            }
        }
        
        return numerator.divide(denonimator);
    }
    
}
