package programmers.lv0.lv0_120842;

class Solution {
    public int[][] solution(int[] num_list, int n) {
        int[][] answer = new int[num_list.length/n][n];
        int num_listIdx = 0;
        for(int i=0; i<num_list.length/n; i++){
            for(int j=0; j<n; j++){
                answer[i][j] = num_list[num_listIdx++];
            }
        }
        return answer;
    }
}