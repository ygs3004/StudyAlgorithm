import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.Arrays;

public class Main {

    static int[][] dp;
    private static final int RED = 0;
    private static final int GREEN = 1;
    private static final int BLUE = 2;
    static int MAX = 1000;

    public static void main(String[] args) throws IOException {

        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        int homeCount = Integer.parseInt(br.readLine());
        int[][] cost = new int[homeCount][3];

        for(int i = 0; i < homeCount; i++){
            String[] colorCost = br.readLine().split(" ");
            int redCost = Integer.parseInt(colorCost[RED]);
            int greenCost = Integer.parseInt(colorCost[GREEN]);
            int blueCost = Integer.parseInt(colorCost[BLUE]);
            cost[i][RED] = redCost;
            cost[i][GREEN] = greenCost;
            cost[i][BLUE] = blueCost;
        }

        int result = Integer.MAX_VALUE;
        for(int i = RED; i <= BLUE; i++){
            dp = new int[homeCount][3];
            for(int j = 0; j < homeCount; j++){
                if(j == 0) {
                    dp[j][RED] = i == RED ? cost[j][RED] : MAX;
                    dp[j][GREEN] = i == GREEN ? cost[j][GREEN] : MAX;
                    dp[j][BLUE] = i == BLUE ? cost[j][BLUE] : MAX;
                }else if(j == homeCount - 1){
                    dp[j][RED] += i == RED ? MAX * 1000 : Math.min(dp[j - 1][BLUE], dp[j-1][GREEN]) + cost[j][RED];
                    dp[j][BLUE] += i == BLUE ? MAX * 1000 : Math.min(dp[j - 1][RED], dp[j-1][GREEN]) + cost[j][BLUE];
                    dp[j][GREEN] += i == GREEN ? MAX * 1000 :  Math.min(dp[j - 1][BLUE], dp[j-1][RED]) + cost[j][GREEN];
                }else{
                    dp[j][RED] += Math.min(dp[j - 1][BLUE], dp[j-1][GREEN]) + cost[j][RED];
                    dp[j][BLUE] += Math.min(dp[j - 1][RED], dp[j-1][GREEN]) + cost[j][BLUE];
                    dp[j][GREEN] += Math.min(dp[j - 1][BLUE], dp[j-1][RED]) + cost[j][GREEN];
                }
            }
            result = Math.min(result, dp[homeCount-1][0]);
            result = Math.min(result, dp[homeCount-1][1]);
            result = Math.min(result, dp[homeCount-1][2]);
        }
        System.out.println(result);
    }

}
