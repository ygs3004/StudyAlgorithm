package programmers.lv0.lv0_120864;

class Solution {
    
    public int solution(String my_string) {

        System.out.println((int)'0'); // 48
        System.out.println((int)'9'); // 57
        int sum = 0;
        String number = "";
        
        for(int i=0; i<my_string.length(); i++){
            
            if(my_string.charAt(i)>= 48 && my_string.charAt(i) <= 57){
                number += Character.toString(my_string.charAt(i));
                System.out.println("number: " + number);
            }else if(number.length()>0){
                System.out.println("number: " + number);
                sum += Integer.parseInt(number);
                System.out.println("sum: " + number);
                number = "";
            }
            
        }
        
        if(number.length() > 0) sum += Integer.parseInt(number);
        
        return sum;
        
    }
    
}