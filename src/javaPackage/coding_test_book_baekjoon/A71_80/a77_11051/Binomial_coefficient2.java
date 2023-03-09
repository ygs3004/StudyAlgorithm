package javaPackage.coding_test_book_baekjoon.A71_80.a77_11051;

import java.io.BufferedReader;
import java.io.InputStreamReader;
import java.util.StringTokenizer;

/*
이항 계수 2
문제
자연수 \(N\)과 정수 \(K\)가 주어졌을 때 이항 계수
\(\binom{N}{K}\)를 10,007로 나눈 나머지를 구하는 프로그램을 작성하시오.

입력
첫째 줄에 \(N\)과 \(K\)가 주어진다. (1 ≤ \(N\) ≤ 1,000, 0 ≤ \(K\) ≤ \(N\))

출력

\(\binom{N}{K}\)를 10,007로 나눈 나머지를 출력한다.

예제 입력 1
5 2
예제 출력 1
10
*/
public class Binomial_coefficient2 {

    public static void main(String[] args) throws Exception{

        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer st = new StringTokenizer(br.readLine());
        int n = Integer.parseInt(st.nextToken());
        int k = Integer.parseInt(st.nextToken());
        int[][] D = new int[n+1][n+1];
        for(int i=0; i<=n; i++){
            D[i][1] = i;
            D[i][0] = 1;
            D[i][i] = 1;
        }

        for(int i=2; i<=n; i++){
            for(int j=1; j<i; j++){
                D[i][j] = D[i-1][j-1] + D[i-1][j];
                D[i][j] = D[i][j] % 10007;
            }
        }
        System.out.println(D[n][k]);
    }

}
