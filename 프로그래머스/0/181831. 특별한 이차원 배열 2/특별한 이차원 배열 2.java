class Solution {
    public int solution(int[][] arr) {
        int maxIdx = arr.length;
        int answer = 1;
        for(int i = 0; i < maxIdx; i++){
            for(int j = 0; j < maxIdx; j++){
                if(arr[i][j] != arr[j][i]){
                    answer = 0; 
                    break;
                }
            }
        }
        
        return answer;
    }
}