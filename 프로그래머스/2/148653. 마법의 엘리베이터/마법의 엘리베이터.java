class Solution {
    public int solution(int storey) {
        String[] number = Integer.toString(storey).split("");
        int answer = 0;
        
        for(int i = number.length - 1; i >= 0; i--){
            int n = Integer.parseInt(number[i]);
           
            if(n > 5){
                answer += (10 - n);
                if(i == 0){
                    answer ++;  
                } else{
                    number[i-1] = Integer.toString(Integer.parseInt(number[i-1]) + 1);
                }
                
            }else if(n < 5){
                answer += n;
                
            }else{
                
                if(i != 0 && Integer.parseInt(number[i-1]) >= 5){
                    answer += (10 - n);
                    number[i-1] = Integer.toString(Integer.parseInt(number[i-1]) + 1);
                }else{
                    answer += n;
                }
            }
            
        }
        return answer;
    }
}