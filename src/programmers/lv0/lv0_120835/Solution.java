package programmers.lv0.lv0_120835;

import java.util.Arrays;

class Solution {
    
    public int[] solution(int[] emergency) {
        
        Patient[] patient = new Patient[emergency.length];
        
        for(int i=0; i<emergency.length; i++){
            patient[i] = new Patient(i, emergency[i]);
        }
        
        Arrays.sort(patient);
        int[] answer = new int[patient.length];
        
        for(int i=0; i<patient.length; i++){
            for(int j=0; j<patient.length; j++){
                if(emergency[i] == patient[j].emergency){
                    answer[i] = j+1;
                }
            }
        }
        
        return answer;
    }
    
}

class Patient implements Comparable<Patient>{
    
    int index;
    int emergency;
    
    Patient(int index, int emergency){
        this.index = index;
        this.emergency = emergency;
    }
    
    public int compareTo(Patient p){
        return p.emergency - this.emergency;    
    }
    
}