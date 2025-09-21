import java.util.*;

class Solution {
    public int solution(int[][] jobs) {
        
        PriorityQueue<Job> timeQueue = new PriorityQueue<>((j1, j2) -> j1.start - j2.start);
        
        // 모든 요청 작업의 반환 시간의 평균 = 반환시각의합 / 전체작업 개수
        for(int i = 0; i < jobs.length; i++){
            int[] job = jobs[i];
            Job newJob = new Job(i, job[0], job[1]);
            timeQueue.add(newJob);
        }
        
        int now = 0;
        int totalJobCnt = timeQueue.size();
        int totalJobWorking = 0;
        
        PriorityQueue<Job> que = new PriorityQueue<>();
        
        while(!timeQueue.isEmpty() || !que.isEmpty()){
            
            while(!timeQueue.isEmpty() && timeQueue.peek().start <= now){
                Job newJob = timeQueue.poll();
                que.add(newJob);
            }
            
            if(que.isEmpty()){
                now++;
                continue;
            }
            Job job = que.poll();    
            now = now + job.working;
            totalJobWorking += now - job.start;
        }
        
        int answer = totalJobWorking / totalJobCnt;
        return answer;
    }
    
    private static class Job implements Comparable<Job>{
        
        int id;
        int start;
        int working;
        
        Job(int id, int start, int working){
            this.id = id;
            this.start = start;
            this.working = working;
        }
        
        // 작업의 소요시간이 짧은 것, 작업의 요청 시각이 빠른 것, 작업의 번호가 작은 것 순으로 우선순위
        @Override
        public int compareTo(Job o){
            
            if(this.working != o.working){
                return this.working - o.working;
            }
            
            if(this.start != o.start){
                return this.start - o.start;
            }
            
            return this.id - o.id;
        }
    }
}