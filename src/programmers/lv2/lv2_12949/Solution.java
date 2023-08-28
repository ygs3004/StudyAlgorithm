package programmers.lv2.lv2_12949;

class Solution {
    public int[][] solution(int[][] arr1, int[][] arr2) {
        
        int iLength = arr1.length;
        int jLength = arr2[0].length;
        int kLength = arr2.length;
        
        int[][] answer = new int[iLength][jLength];
        
        for(int i = 0; i<iLength; i++ ){
            for(int j = 0; j<jLength; j++){
                int result = 0;
                for(int k=0; k<kLength; k++){
                    result += arr1[i][k]*arr2[k][j];
                }
                answer[i][j] = result;
            }
        }
        
        return answer;
    }
}