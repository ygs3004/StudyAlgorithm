package programmers.unrated.unrated_133502;

import java.util.*;
class Solution {
    public int solution(int[] ingredient) {
        
        Stack<Integer> stack = new Stack<>();
        String nowBurger = "";
        int answer = 0;
        
        for(int food : ingredient){
            if(food == 1){
                if(nowBurger.equals("123")){
                    answer++;
                    stack.pop();
                    stack.pop();
                    stack.pop();
                    nowBurger = "";
                    if(!stack.isEmpty()){
                        if(stack.size() >= 3 && stack.peek() == 3){
                            int pop1 = stack.pop();
                            int pop2 = stack.pop();
                            int pop3 = stack.pop();
                            if(pop1 == 3 && pop2 ==2 && pop1 == 1){
                                nowBurger = "123";
                            }
                            stack.push(pop3);
                            stack.push(pop2);
                            stack.push(pop1);
                        }else if(stack.size() >= 2 && stack.peek() == 2){
                            int pop1 = stack.pop();
                            int pop2 = stack.pop();
                            if(pop1 == 2 && pop2 == 1){
                                nowBurger = "12";
                            }
                            stack.push(pop2);
                            stack.push(pop1);
                        }else if(stack.size() >= 1 && stack.peek() == 1){
                            nowBurger = "1";
                        }else{
                            nowBurger = "";
                        }    
                    }                    
                }else{
                    nowBurger = "1";
                    stack.push(food);
                }
            }else if(food == 2){
                nowBurger = nowBurger.equals("1") ? "12" : "";                
                stack.push(food);
            }else{
                nowBurger = nowBurger.equals("12") ? "123" : "";
                stack.push(food);
            }
        }
        
        
        return answer;
    }
}