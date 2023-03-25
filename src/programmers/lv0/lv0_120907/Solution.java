package programmers.lv0.lv0_120907;

class Solution {
    public String[] solution(String[] quiz) {

        String answer = "";
        
        for(String str : quiz){
            
            String[] xyz = str.split(" ");
            int x = Integer.parseInt(xyz[0]);
            int y = Integer.parseInt(xyz[2]);
            int z = Integer.parseInt(xyz[4]);
            
            String operator = xyz[1];
            
            if(operator.equals("+")){
                if(x+y == z) answer += "O ";
                else answer += "X ";
            }else{
                if(x-y == z) answer += "O ";
                else answer += "X ";
            }
            
        }
        
        String[] result = answer.split(" ");
        
        return result;
    }
}