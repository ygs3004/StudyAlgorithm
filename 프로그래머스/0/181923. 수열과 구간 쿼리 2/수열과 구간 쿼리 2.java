class Solution {
    public int[] solution(int[] arr, int[][] queries) {
        int[] answer = new int[queries.length];
        
        for(int i = 0; i < queries.length; i++){
            int[] query = queries[i];
            int s = query[0];
            int e = query[1];
            int k = query[2];
            
            answer[i] = findMin(arr, s, e, k);
        }
        
        return answer;
    }
    
    public int findMin(int[] arr, int s, int e, int k){
        int result = Integer.MAX_VALUE;
        for(int i = s; i <= e; i++){
            if(arr[i] > k) result = Math.min(arr[i], result);
        }
        return result == Integer.MAX_VALUE ? -1 : result;
    }
    
}