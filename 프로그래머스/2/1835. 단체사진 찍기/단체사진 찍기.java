import java.util.*;

class Solution {
    
    final String[] peoples = {"A", "C", "F", "J", "M", "N", "R", "T"};
    List<Condition> conditions;
    int answer;
    
    public int solution(int n, String[] data) {
        conditions = new ArrayList<>();
        answer = 0;
        
        for(String dataCondition: data){
            Condition condition = new Condition(dataCondition);
            conditions.add(condition);
        }
        
        lineDfs(new StringBuilder(), new boolean[peoples.length]);
        return answer;
    }
    
    private void lineDfs(StringBuilder line, boolean[] visited){

        if(line.length() == 8){
            answer++;
            for(Condition condition: conditions){
                if(!condition.isValid(line.toString())){
                    answer--;
                    break;
                };
            }
            return;
        }
        
        for(int i = 0; i < peoples.length; i++){
            if(!visited[i]){
                visited[i] = true;
                line.append(peoples[i]);
                lineDfs(line, visited);    
                visited[i] = false;
                line.deleteCharAt(line.length() - 1);
            }
        }
        
    }
    
    private class Condition{
        
        String from;
        String to;
        String oper;
        int distance;
        
        Condition(String dataCondition){
            this.from = String.valueOf(dataCondition.charAt(0));
            this.to = String.valueOf(dataCondition.charAt(2));
            this.oper = String.valueOf(dataCondition.charAt(3));
            this.distance = dataCondition.charAt(4) - '0';
        }
        
        boolean isValid(String line){
            int fromIdx = line.indexOf(from);
            int toIdx = line.indexOf(to);
            int distPeople = Math.abs(toIdx - fromIdx) - 1;
            
            boolean result = false;
            switch(oper){
                case "=":
                    result = distPeople == distance;
                    break;
                case "<":
                    result = distPeople < distance;
                    break;
                case ">":
                    result = distPeople > distance;
                    break;
            }
            return result;
        }
    }
    
}