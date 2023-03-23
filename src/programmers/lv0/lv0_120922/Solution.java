package programmers.lv0.lv0_120922;

class Solution {
    public static int solution(int M, int N) {

        int[][] cut = new int[M+1][N+1];
        
        for(int i=1; i<=M; i++){
            for(int j=1; j<=N; j++){
              cut[i][j] = (i-1)+i*(j-1);
            }
        }

        return cut[M][N];
    }
}