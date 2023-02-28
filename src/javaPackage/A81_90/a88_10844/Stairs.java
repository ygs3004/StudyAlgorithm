package javaPackage.A81_90.a88_10844;
/* DP, 다이나미 프로그래밍
45656이란 수를 보자.
이 수는 인접한 모든 자리의 차이가 1이다. 이런 수를 계단 수라고 한다.
N이 주어질 때, 길이가 N인 계단 수가 총 몇 개 있는지 구해보자. 0으로 시작하는 수는 계단수가 아니다.

입력
첫째 줄에 N이 주어진다. N은 1보다 크거나 같고, 100보다 작거나 같은 자연수이다.

출력
첫째 줄에 정답을 1,000,000,000으로 나눈 나머지를 출력한다.

예제 입력 1
1
예제 출력 1
9
예제 입력 2
2
예제 출력 2
17
*/

import java.io.BufferedReader;
import java.io.InputStreamReader;

public class Stairs {

    public static void main(String[] args) throws Exception{
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        int n = Integer.parseInt(br.readLine());
        long[][] D = new long[n+1][10];
        long mod = 1000000000;
        for(int i=1; i<=9; i++){
            D[1][i]=1; // 자릿수가 1개일때 i로 끝나는 경우는 하나
        }

        for(int i=2; i<=n; i++){
            D[i][0]=D[i-1][1];
            D[i][9]=D[i-1][8];
            for(int j=1; j<=8; j++){
                D[i][j]=(D[i-1][j-1]+D[i-1][j+1])%mod;
            }
        }
        long result = 0;
        for(int i=0; i<10; i++){
            result = (result + D[n][i])%mod;
        }
        System.out.println(result);
    }

}