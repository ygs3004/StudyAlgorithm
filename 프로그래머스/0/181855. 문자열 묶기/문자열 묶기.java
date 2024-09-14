class Solution {
    public int solution(String[] strArr) {
        int[] result = new int[31];
        for(String str : strArr){
            result[str.length()]++;
        }
        
        int answer = 0;
        for(int size : result){
            answer = Math.max(answer, size);
        }
        
        return answer;
    }
}