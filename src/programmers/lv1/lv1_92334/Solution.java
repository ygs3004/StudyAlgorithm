package programmers.lv1.lv1_92334;

import java.util.*;
class Solution {
    public int[] solution(String[] id_list, String[] report, int k) {
        
        String reporter = "";
        String user = "";
        String[] reportContent = new String[2];
        int userId = 0;
        int[] answer = new int[id_list.length];
        
        List list = Arrays.asList(id_list);
        Set[] setArr = new Set[id_list.length];
        for(int i=0; i<setArr.length; i++){
            setArr[i] = new HashSet<String>();
        }
        
        for(String record : report){
            reportContent = record.split(" ");
            reporter = reportContent[0];
            user = reportContent[1];
            userId = list.indexOf(user);
            setArr[userId].add(reporter);
        }
        
        for(Set set : setArr){
            if(set.size()>=k){
                Iterator itr = set.iterator();
                while(itr.hasNext()){
                    answer[list.indexOf(itr.next())]++;
                }
            }
        }        
        
        return answer;
    }
}