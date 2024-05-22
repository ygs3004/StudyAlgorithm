import java.util.*;

class Solution {
    public long solution(String expression) {
        String[][] allCase = new String[][]{
            {"+", "-", "*"}, {"+", "*", "-"}, {"-", "*", "+"},
            {"-", "+", "*"}, {"*", "+", "-"}, {"*", "-", "+"}
        };
        Queue<String> partQueue = new LinkedList<>();
        StringBuilder part = new StringBuilder();
        for(int i = 0; i < expression.length(); i++){
            char letter = expression.charAt(i);
            if(!isOper(letter)){
                part.append(letter);
            }else{
                partQueue.add(part.toString());
                part.setLength(0);
                partQueue.add(String.valueOf(letter));
            }   
        }

        partQueue.add(part.toString());
        
        long answer = 0;
        for(String[] operCase : allCase){
            Queue<String> calcQueue = new LinkedList<>(partQueue);
            for(String checkOper : operCase){
                int beforeSize = calcQueue.size();
                int afterSize = 0;
                while(beforeSize != afterSize){
                    beforeSize = calcQueue.size();
                    calcQueue = calcOper(calcQueue, checkOper);
                    afterSize = calcQueue.size();
                }
            }

            long calcResult = Math.abs(Long.parseLong(calcQueue.peek()));
            answer = Math.max(answer, calcResult);
        }
        
        return answer;
    }
    
    private Queue<String> calcOper(Queue<String> partQueue, String oper){
        Queue<String> resultQueue = new LinkedList<>();
        while(!partQueue.isEmpty()){
            String numA = partQueue.poll();
            
            if(partQueue.isEmpty()){
                resultQueue.add(numA);
                break;
            }
            
            String operPart = partQueue.poll();
            
            if(operPart.equals(oper)){
                String numB = partQueue.poll();
                String resultNum = calcUnit(numA, numB, operPart);
                resultQueue.add(resultNum);
            }else{
                resultQueue.add(numA);
                resultQueue.add(operPart);
            }
        }
        
        return resultQueue;
    }
    
    private boolean isOper(String str){
        return str.length() == 1 && isOper(str.charAt(0));
    }
    
    private boolean isOper(char letter){
        return !(letter >= '0' && letter <= '9');
    }
    
    private String calcUnit(String numA, String numB, String oper){
        
        String result = "";
        
        switch(oper){
            case "+":
                result = String.valueOf(Long.parseLong(numA) + Long.parseLong(numB));
                break;
            case "-":
                result = String.valueOf(Long.parseLong(numA) - Long.parseLong(numB));
                break;
            case "*":
                result = String.valueOf(Long.parseLong(numA) * Long.parseLong(numB));
                break;
        }
        
        return result;
    }
}