class Solution {
    public int[] solution(int[] arr, int[][] intervals) {
        int s1 = intervals[0][0];
        int s2 = intervals[1][0];
        
        int e1 = intervals[0][1];
        int e2 = intervals[1][1];
        int[] answer = new int[(e1 - s1) + (e2 - s2) + 2];
        int index = 0;
        
        for(int i = s1; i <= e1; i++){
            answer[index++] = arr[i];
        }
        
        for(int i = s2; i <= e2; i++){
            answer[index++] = arr[i];
        }
        
        return answer;
    }
}