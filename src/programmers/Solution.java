package programmers;

class Solution {
    public static int solution(int M, int N) {

        int[][] dp = new int[M+1][N+1];

        dp[1][1] = 0;
        dp[0][0] = 0;
        dp[1][0] = 0;
        dp[0][1] = 0;
        dp[2][1] = 1;
        dp[1][2] = 1;
        int i = 1;
        int j = 1gi;

        while(i != M || j != N){
//            System.out.println(i);
//            System.out.println(j);
            dp[i++][j++] = dp[i-1][j]+1;

            if(i<M){
                dp[i+1][j] = dp[i][j]+1;
            }
            if(j<N){
                dp[i][j+1] = dp[i][j]+1;
            }
        }

        return dp[M][N];
    }

    public static void main(String[] args) {
        System.out.println(solution(2, 2)); // 3
        System.out.println(solution(2, 5)); // 9
        System.out.println(solution(1, 1)); // 0
    }
}
