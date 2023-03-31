package programmers.lv1.lv1_42889;

import java.util.*;
class Solution {
    
    public int[] solution(int N, int[] stages) {
        
        int[] reach = new int[N+2];
        double[] fail = new double[N+1];
        
        for(int i=0; i<stages.length; i++){
            reach[stages[i]]++;
        }
        
        int totalReachPeople = stages.length;
        for(int i=1; i<N+1; i++){
            if(totalReachPeople == 0){
                fail[i] = 0;    
            }else{
                fail[i] = (double)reach[i]/totalReachPeople;    
                totalReachPeople -= reach[i];
            }
        }
        
        Stage[] stagesFail = new Stage[N];
        for(int i=0; i<stagesFail.length; i++){
            stagesFail[i] = new Stage(i+1, fail[i+1]);
        }

        Arrays.sort(stagesFail);

        int[] answer = new int[N];
        for(int i=0; i<N; i++){
            answer[i] = stagesFail[i].stageNum;
        }
        
        return answer;
    }
    
}

class Stage implements Comparable<Stage>{
    
    int stageNum;
    double fail=0;
    
    Stage(int stageNum, double fail){
        this.stageNum = stageNum;
        this.fail = fail;
    }
    
    @Override
    public int compareTo(Stage newStage){
            if(newStage.fail == this.fail){
                return this.stageNum - newStage.stageNum;
            }
         return (newStage.fail - this.fail) > 0 ? 1 : -1;
    }
    
    public String toString(){
        return stageNum + " " + fail;
    }
}
