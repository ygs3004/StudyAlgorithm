import java.util.*;

class Solution {
    public int solution(int[][] scores) {
        int baseScore = scores[0][0] + scores[0][1];
        
        PriorityQueue<int[]> attitudePq = new PriorityQueue<>((a, b) -> {
            if(b[0] == a[0] && b[1] == a[1]){
                return b[2] - a[2];
            }else if(b[0] == a[0]){
                return a[1] - b[1];
            }
            return b[0] - a[0];
        });
        PriorityQueue<int[]> workerPq = new PriorityQueue<>((a, b) -> {
            if(b[0] == a[0] && b[1] == a[1]){
                return b[2] - a[2];
            }else if(b[1] == a[1]){
                return b[0] - a[0];
            }
            return a[1] - b[1];
        });
        List<int[]> total = new ArrayList<>();
        
        for(int i = 0; i < scores.length; i++){
            int[] score = scores[i];
            attitudePq.add(new int[]{score[0], score[1], i});
            workerPq.add(new int[]{score[0], score[1], i});
        }
        
        boolean[] bad = new boolean[scores.length];
        while(!attitudePq.isEmpty()){
            int[] score = attitudePq.poll();
            int id = score[2];
            if(bad[id]) continue;
            
            List<int[]> save = new ArrayList<>();
            while(!workerPq.isEmpty()){
                int[] check = workerPq.poll();
                int checkId = check[2];
                if(checkId == id){
                    break;
                }else if(check[1] >= score[1] || check[0] >= score[0]){
                    save.add(check);
                }else{
                    bad[checkId] = true;    
                }
            }
            
            for(int[] saveScore: save){
                workerPq.add(saveScore);
            }
            
            if(score[0] + score[1] > baseScore){
                total.add(score);    
            }
        }
        
        return bad[0] ? -1 : total.size() + 1;
    }
}