package programmers.unrated.unrated_150370;

import java.util.*;
class Solution {
    public int[] solution(String today, String[] terms, String[] privacies) {
        
        Map<String, String> termInfo = new HashMap<>();
        String[] termDetail = new String[2];
        String[] endTerms = new String[privacies.length];
        String termName = "";
        String termMonth = "";
        String privaTerm = "";
        int monthGap = 0;
        String privaYear = "";
        String privaMonth = "";
        String privaDate = "";
        int endMonth = 0;
        int endYear = 0;
        String endTerm = "";
        String answer = "";
            
        for(int i=0; i<terms.length; i++){
            termDetail = terms[i].split(" ");
            termName = termDetail[0];
            termMonth = termDetail[1];
            termInfo.put(termName, termMonth);
        }       
                    
        for(int i=0; i<privacies.length; i++){
            privaTerm = String.valueOf(privacies[i].charAt(privacies[i].length()-1));
            monthGap = Integer.parseInt(termInfo.get(privaTerm));
            privaYear = privacies[i].substring(0, 4);
            privaMonth = privacies[i].substring(5,7);
            privaDate = privacies[i].substring(8,10);
            endMonth = Integer.parseInt(privaMonth) + monthGap;
            endYear = Integer.parseInt(privaYear);
            if(endMonth > 12){
                endYear += endMonth%12 == 0 ? endMonth/12-1 : endMonth/12;
                endMonth = endMonth%12 == 0 ? 12 : endMonth%12;
            }
            if(endMonth<10){
                endTerm = endYear+".0"+endMonth+"."+privaDate;
            }else{
                endTerm = endYear+"."+endMonth+"."+privaDate;
            }
            endTerms[i] = endTerm;
        }
        
        for(int i=0; i<endTerms.length; i++){
            if(today.compareTo(endTerms[i]) >= 0) answer += (i+1)+",";
        }
        String[] resultString = answer.split(",");
        int[] result = new int[resultString.length];
   
        for(int i=0; i<resultString.length; i++){
            result[i] = Integer.parseInt(resultString[i]);
        }
        
        return result;
    }
}