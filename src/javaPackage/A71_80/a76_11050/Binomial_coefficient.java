package javaPackage.A71_80.a76_11050;
/* 이항계수, 조합, 점화식
D[i][j] = D[i-1][j] + D[i-1][j-1]
자연수 N과 정수 K가 주어졌을 때 이항 계수 -> N개의 숫자에서 K개를 고르는 경우의 수
(binom{N}{K})를 구하는 프로그램을 작성하시오.

입력
첫째 줄에 N과 K가 주어진다. (1 ≤ N ≤ 10, 0 ≤ K ≤ N)

출력

(binom{N}{K})를 출력한다.

예제 입력 1
5 2
예제 출력 1
10
*/

import java.io.BufferedReader;
import java.io.InputStreamReader;
import java.util.StringTokenizer;

public class Binomial_coefficient {

    public static void main(String[] args) throws Exception{
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer st = new StringTokenizer(br.readLine());
        int n = Integer.parseInt(st.nextToken());
        int k = Integer.parseInt(st.nextToken());
        int[][] D = new int[n+1][n+1];

        for(int i=0; i<=n; i++){
            D[i][1] = i; //i 개에서 1개 선택 경우의 수 1개
            D[i][0] = 1; //i 개에서 1개도 선택하지 않는 경우의 수 0개
            D[i][i] = 1; // i개에서 모두 선택하는 경우의 수 1
        }

        for(int i=2; i<=n; i++){
            for(int j=1; j<i; j++){
                D[i][j] = D[i-1][j] + D[i-1][j-1];
            }
        }

        System.out.println(D[n][k]);

    }

}