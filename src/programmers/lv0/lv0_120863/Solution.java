package programmers.lv0.lv0_120863;

class Solution {
    public String solution(String polynomial) {
        String[] str = polynomial.split(" \\+ ");
        
        int xNum = 0;
        int constant = 0;
        
        for(String n : str){
            System.out.println(n);
            if(n.contains("x")){
              if(n.length() == 1){
                 xNum++; 
              }else{
                n = n.replaceAll("x", "");    
                xNum += Integer.parseInt(n);  
              }
            }else{
              constant +=  Integer.parseInt(n);  
            } 
                            
        }
 
        String result = xNum > 1 && constant > 0 ? xNum+"x" + " + " + constant :
                        xNum == 1 && constant > 0 ? "x" + " + " + constant :
                        xNum == 1 ? "x" :
                        xNum > 0 ?  xNum+"x" : constant + "";
            
        return result;
    }
}